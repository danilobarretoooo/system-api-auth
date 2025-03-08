package danilobarreto.dev.systemapiauth.repository;

import danilobarreto.dev.systemapiauth.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    @Query("SELECT p FROM Pessoa p WHERE p.excluido = 'N'")
    List<Pessoa> findAllAtivos();
}
