package school.sptech.cursos.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Getter
@Setter
public class Inscricao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String nome;
    @NotBlank
    @Email
    private String email;
    @Past
    @NotNull
    private LocalDate dataNascimento;
    @DateTimeFormat
    @NotNull
    private LocalDate dataInscricao;


    @ManyToOne
    private Curso curso;

    public boolean isMaiorDe18Anos() {

        Integer idade = dataInscricao.getYear()- dataNascimento.getYear();
        if (idade>=18){
            return true;
        }
        return false;
    }
}
