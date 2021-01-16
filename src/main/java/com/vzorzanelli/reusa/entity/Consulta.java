package com.vzorzanelli.reusa.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TCONSULTA")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DATA_CRIACAO")
    private Date dataCriacao;

    @Column(name = "DATA_MODIFICACAO")
    private Date dataModificacao;

    @Column(name = "SINTOMAS", length = 2000)
    private String sintomas;

    @Column(name = "DIAGNOSTICO", length = 2000)
    private String diagnostico;

    @Column(name = "TRATAMENTO", length = 2000)
    private String tratamento;

    @ManyToOne
    @JoinColumn(name="PACIENTE_USUARIO_ID", nullable=false)
    private Usuario paciente;

    @ManyToOne
    @JoinColumn(name="MEDICO_USUARIO_ID", nullable=false)
    private Usuario medico;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(Date dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamento() {
        return tratamento;
    }

    public void setTratamento(String tratamento) {
        this.tratamento = tratamento;
    }

    public Usuario getPaciente() {
        return paciente;
    }

    public void setPaciente(Usuario paciente) {
        this.paciente = paciente;
    }

    public Usuario getMedico() {
        return medico;
    }

    public void setMedico(Usuario medico) {
        this.medico = medico;
    }
}
