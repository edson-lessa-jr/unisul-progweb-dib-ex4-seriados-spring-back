package br.unisul.aula.ex5seriadosspringback.controladores;

import br.unisul.aula.ex5seriadosspringback.dtos.TemporadaDTO;
import br.unisul.aula.ex5seriadosspringback.entidades.Seriado;
import br.unisul.aula.ex5seriadosspringback.entidades.Temporada;
import br.unisul.aula.ex5seriadosspringback.repositorio.SeriadoRepositorio;
import br.unisul.aula.ex5seriadosspringback.repositorio.TemporadaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/temporada")
public class TemporadaControlador {

    @Autowired
    private TemporadaRepositorio temporadaRepositorio;
    @Autowired
    private SeriadoRepositorio seriadoRepositorio;

    @GetMapping("/")
    public List<TemporadaDTO> listarTodasTemporadas(){
        List<Temporada> temporadaList = temporadaRepositorio.findAll();
        return TemporadaDTO.converteListaTemporada(temporadaList);
    }
    @GetMapping("/id") // http://localhost:9091/temporada/id?id=2
    public TemporadaDTO buscarTemporadaPorID(Long id){
        Temporada temporada = temporadaRepositorio.getById(id);
        return new TemporadaDTO(temporada);
    }
    @PostMapping("/")
    public void insererUmaTemporada(@RequestBody TemporadaDTO dto){
        Seriado seriado = seriadoRepositorio.getById(dto.getSeriadoId());
        temporadaRepositorio.save(dto.converterParaTemporada(seriado));
    }

    @PutMapping("/{id}")
    public void alterarUmaTemporada(@PathVariable(name = "id")Long id, @RequestBody TemporadaDTO dto){
        Temporada temporada = temporadaRepositorio.getById(id);
        Seriado seriado = seriadoRepositorio.getById(dto.getSeriadoId());
        dto.converterAlteracaoParaTemporada(temporada,seriado);
        temporadaRepositorio.save(temporada);

    }
    @DeleteMapping("/{id}")
    public void deletarUmaTemporada(@PathVariable(name = "id")Long id){
        temporadaRepositorio.deleteById(id);
    }
}

