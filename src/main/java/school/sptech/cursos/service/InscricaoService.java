package school.sptech.cursos.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import school.sptech.cursos.entity.Curso;
import school.sptech.cursos.entity.Inscricao;
import school.sptech.cursos.repository.CursoRepository;
import school.sptech.cursos.repository.InscricaoRepository;

import java.time.LocalDate;
import java.util.List;
@Service
@RequiredArgsConstructor
public class InscricaoService {

    private final CursoRepository cursoRepository;
    private final InscricaoRepository inscricaoRepository;
    public List<Inscricao> findAll() {
        return inscricaoRepository.findAll();
    }

    public Inscricao findById(Integer id) {
        return inscricaoRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Inscrição não encontrada"));

    }

    public Inscricao save(Inscricao inscricao, Integer idCurso) {
        Curso curso = cursoRepository.findById(idCurso).orElse(null);
        if(curso == null){
            return null;
        }

        if (inscricao.isMaiorDe18Anos()) {
            inscricao.setCurso(curso);
            return inscricaoRepository.save(inscricao);
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Menor de idade");
    }

    public void delete(Integer id) {
        inscricaoRepository.deleteById(id);
    }
}
