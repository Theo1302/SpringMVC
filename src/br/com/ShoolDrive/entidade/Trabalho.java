package br.com.ShoolDrive.entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "trabalho")
@SequenceGenerator(name = "trabalho_seq", sequenceName = "trabalho_seq", allocationSize = 1, initialValue = 1)
public class Trabalho implements Serializable {

    private static final long serialVersionUID = 1L;

    public Trabalho() {}

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "trabalho_seq")
    private long id;

    @Column
    private String titulo;

    /*
     * @Column(name = "data_limite")
     * private String dataLimite;
     */

    @Column(name = "data_limite")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private DateTime dataLimite;


    @Column(columnDefinition = "TEXT")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "disciplina_Id")
    private Disciplina disciplina;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "trabalho")
    private List<Entrega> entregas;

    public List<Entrega> getEntregas() {
        return this.entregas;
    }

    public void setEntregas(List<Entrega> entregas) {
        this.entregas = entregas;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public DateTime getDataLimite() {
        return this.dataLimite;
    }

    public void setDataLimite(DateTime dataLimite) {
        this.dataLimite = dataLimite;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Disciplina getDisciplina() {
        return this.disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }



}
