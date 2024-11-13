package school.sptech.cursos.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.cursos.entity.Curso;
import school.sptech.cursos.entity.Inscricao;
import school.sptech.cursos.repository.CursoRepository;
import school.sptech.cursos.repository.InscricaoRepository;
import school.sptech.cursos.service.CursoService;
import school.sptech.cursos.service.InscricaoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inscricoes")
public class InscricaoController {

    @Autowired
    private InscricaoRepository inscricaoRepository;
    @Autowired
    private InscricaoService inscricaoService;
    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public ResponseEntity<List<Inscricao>> findAll() {
        List<Inscricao> inscricoes = inscricaoRepository.findAll();
        if(inscricoes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(inscricoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inscricao> findById(@PathVariable Integer id) {
        Inscricao inscricao = inscricaoService.findById(id);
        if (inscricao == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(inscricao);
    }

    @PostMapping("/cursos/{idCurso}")
    public ResponseEntity<Inscricao> save(
            @PathVariable Integer idCurso,
            @RequestBody @Valid Inscricao inscricao
    ) {
        Curso curso = cursoRepository.findById(idCurso).orElse(null);
        if (curso == null) {
            return ResponseEntity.status(404).build();
        }
        Optional<Inscricao> inscricao1 = inscricaoRepository.findByEmailIgnoreCase(inscricao.getEmail());
        if(inscricao1.isPresent()){
            return ResponseEntity.status(409).build();
        }
        if(!inscricao.isMaiorDe18Anos()){
            return ResponseEntity.status(400).build();
        }
        inscricaoRepository.save(inscricao);
        return ResponseEntity.status(201).body(inscricao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!inscricaoRepository.existsById(id)) {
            return ResponseEntity.status(404).build();
        }
        inscricaoService.delete(id);
        return ResponseEntity.status(204).build();
    }
}
