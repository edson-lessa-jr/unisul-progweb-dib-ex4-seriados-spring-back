package br.unisul.aula.ex5seriadosspringback.repositorio;

import br.unisul.aula.ex5seriadosspringback.entidades.Seriado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeriadoRepositorio extends JpaRepository<Seriado, Long> {

    List<Seriado> findAllByNomeContains(String nome);

}
