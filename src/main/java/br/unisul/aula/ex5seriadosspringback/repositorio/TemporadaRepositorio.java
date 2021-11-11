package br.unisul.aula.ex5seriadosspringback.repositorio;

import br.unisul.aula.ex5seriadosspringback.entidades.Temporada;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemporadaRepositorio  extends JpaRepository<Temporada, Long> {
}
