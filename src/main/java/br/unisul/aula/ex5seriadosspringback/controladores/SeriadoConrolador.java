package br.unisul.aula.ex5seriadosspringback.controladores;

import br.unisul.aula.ex5seriadosspringback.dtos.SeriadoDTO;
import br.unisul.aula.ex5seriadosspringback.entidades.Seriado;
import br.unisul.aula.ex5seriadosspringback.repositorio.SeriadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/seriado")
public class SeriadoConrolador {
    @Autowired
    private SeriadoRepositorio seriadoRepositorio;

    @GetMapping("/")
    public List<SeriadoDTO> listarTodosSeriados(){
        List<Seriado> seriadoList = seriadoRepositorio.findAll();
        // CONVERSÃO PARA DTO
        return SeriadoDTO.converterListaDTO(seriadoList);
    }

    @GetMapping("/id/{numero}")
    public SeriadoDTO buscarSeriadoId(@PathVariable(name = "numero") Long id){
        SeriadoDTO dto = new SeriadoDTO(seriadoRepositorio.getById(id));
        return dto;
    }

    @GetMapping("/nome/{nome}")
    public List<SeriadoDTO> buscarSeriadoPorNome(@PathVariable(name = "nome")String nome){
        List<Seriado> seriadoList = seriadoRepositorio.findAllByNomeContains(nome);
        return SeriadoDTO.converterListaDTO(seriadoList);
    }

    @PostMapping("/")
    public SeriadoDTO inserirUmSeriado(@RequestBody SeriadoDTO dto){
        Seriado seriado = dto.converterParaSeriado();
        Seriado novoSeriado = seriadoRepositorio.save(seriado);
        SeriadoDTO seriadoDTO = new SeriadoDTO(novoSeriado);
        return seriadoDTO;
    }

    @PutMapping("/{id}")
    public void altararUmSeriado(@PathVariable(name = "id") Long id, @RequestBody SeriadoDTO dto ){
        Seriado seriado = seriadoRepositorio.getById(id);
        dto.converterParaAlteracaoSeriado(seriado);
        seriadoRepositorio.save(seriado);
    }

    @DeleteMapping("/{id}")
    public void deletarSeriado(@PathVariable(name = "id")Long id){
        seriadoRepositorio.deleteById(id);
    }
}
