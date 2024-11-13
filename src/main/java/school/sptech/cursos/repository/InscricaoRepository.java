package school.sptech.cursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.cursos.entity.Inscricao;

import java.util.Optional;

public interface InscricaoRepository extends JpaRepository<Inscricao, Integer> {
    Optional<Inscricao> findByEmailIgnoreCase(String email);
}
