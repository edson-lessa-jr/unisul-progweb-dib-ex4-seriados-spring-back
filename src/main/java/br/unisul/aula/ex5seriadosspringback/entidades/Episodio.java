package br.unisul.aula.ex5seriadosspringback.entidades;

import javax.persistence.*;

@Entity
@Table(name = "tb_episodio")
@SequenceGenerator(name = "seq_episodio", sequenceName = "episodio_seq", initialValue = 1, allocationSize = 1)
public class Episodio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_episodio")
    private Long id;
    @Column(nullable = false)
    private int numero;
    @Column(nullable = false)
    private String nome;
    private String resumo;

    @ManyToOne
    @JoinColumn(name = "temporada_id", nullable = false)
    private Temporada temporada;

    public Episodio() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public Temporada getTemporada() {
        return temporada;
    }

    public void setTemporada(Temporada temporada) {
        this.temporada = temporada;
    }

    @Override
    public String toString() {
        return "Episodio{" +
                "id=" + id +
                ", numero=" + numero +
                ", nome='" + nome + '\'' +
                ", resumo='" + resumo + '\'' +
                ", temporada=" + temporada +
                '}';
    }
}
