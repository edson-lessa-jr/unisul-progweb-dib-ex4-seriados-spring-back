package br.unisul.aula.ex5seriadosspringback.dtos;

import br.unisul.aula.ex5seriadosspringback.entidades.Seriado;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SeriadoDTO {
    public static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private Long id;
    private String nome;
    private String dataLancamento;

    public SeriadoDTO() {
    }

    public SeriadoDTO(Seriado seriado) {
        this.id = seriado.getId();
        this.nome = seriado.getNome();
        this.dataLancamento = this.converterLocalDate(seriado.getDataLancamento());
    }
    public static List<SeriadoDTO> converterListaDTO(List<Seriado> seriadoList) {
        List<SeriadoDTO> seriadoDTOS = new ArrayList<>();
        for (Seriado seriado : seriadoList) {
            SeriadoDTO dto = new SeriadoDTO(seriado);
            seriadoDTOS.add(dto);
        }
        return seriadoDTOS;
    }
    private String converterLocalDate(LocalDate dataLancamento) {
        return dataLancamento.format(FORMATO);
    }

    private LocalDate converterStringParaLocalDate(String dataLancamento) {
        return LocalDate.parse(dataLancamento,FORMATO);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    @Override
    public String toString() {
        return "SeriadoDTO\n" +
                "id= " + id +
                ", nome=" + nome +
                ", dataLancamento=" + dataLancamento;
    }

    public Seriado converterParaSeriado() {
        Seriado seriado = new Seriado();
         seriado.setNome(this.nome);
         LocalDate data = this.converterStringParaLocalDate(this.dataLancamento);
         seriado.setDataLancamento(data);
        return seriado;
    }
    public Seriado converterParaAlteracaoSeriado(Seriado seriado) {
         seriado.setNome(this.nome);
         LocalDate data = this.converterStringParaLocalDate(this.dataLancamento);
         seriado.setDataLancamento(data);
        return seriado;
    }
}
