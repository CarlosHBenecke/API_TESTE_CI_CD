package school.sptech.cursos.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.cursos.entity.Curso;
import school.sptech.cursos.repository.CursoRepository;
import school.sptech.cursos.service.CursoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<Curso>> findAll() {
        List<Curso> cursos = cursoRepository.findAll();
        if(cursos.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(cursos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> findById(@PathVariable Integer id) {
        Curso curso = cursoService.findById(id);
        if(curso == null){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(curso);
    }

    @PostMapping
    public ResponseEntity<Curso> save(@RequestBody @Valid Curso curso) {
        Optional<Curso> existingShow = cursoRepository.findByNomeIgnoreCase(curso.getNome());
        if (existingShow.isPresent()) {
            return ResponseEntity.status(409).build();
        }
        Curso cursoSalvo = cursoService.save(curso);
        return ResponseEntity.status(201).body(cursoSalvo);
    }
}
