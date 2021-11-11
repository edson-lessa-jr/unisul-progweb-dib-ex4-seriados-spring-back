package br.unisul.aula.ex5seriadosspringback.dtos;

import br.unisul.aula.ex5seriadosspringback.entidades.Seriado;
import br.unisul.aula.ex5seriadosspringback.entidades.Temporada;

import java.util.ArrayList;
import java.util.List;

public class TemporadaDTO {
    private Long id;
    private Integer numero;
    private String descricao;
    private Long seriadoId;
    private String nomeSeriado;


    public TemporadaDTO(Temporada temporada) {
        this.id = temporada.getId();
        this.numero = temporada.getNumero();
        this.descricao = temporada.getDescricao();
        this.seriadoId = temporada.getSeriado().getId();
        this.nomeSeriado = temporada.getSeriado().getNome();
    }

    public TemporadaDTO() {
    }

    public static List<TemporadaDTO> converteListaTemporada(List<Temporada> temporadaList) {
        List<TemporadaDTO> dtos = new ArrayList<>();
        for (int i = 0; i < temporadaList.size(); i++) {
            TemporadaDTO dto = new TemporadaDTO(temporadaList.get(i));
            dtos.add(dto);
        }
        return dtos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public Long getSeriadoId() {
        return seriadoId;
    }

    public void setSeriadoId(Long seriadoId) {
        this.seriadoId = seriadoId;
    }

    public String getNomeSeriado() {
        return nomeSeriado;
    }

    public void setNomeSeriado(String nomeSeriado) {
        this.nomeSeriado = nomeSeriado;
    }

    public Temporada converterParaTemporada(Seriado seriado) {
        Temporada temporada = new Temporada();
        temporada.setId(this.id);
        temporada.setNumero(this.numero);
        temporada.setDescricao(this.descricao);
        temporada.setSeriado(seriado);
        return temporada;
    }
    public Temporada converterAlteracaoParaTemporada(Temporada temporada, Seriado seriado) {
        temporada.setNumero(this.numero);
        temporada.setDescricao(this.descricao);
        temporada.setSeriado(seriado);
        return temporada;
    }
}
