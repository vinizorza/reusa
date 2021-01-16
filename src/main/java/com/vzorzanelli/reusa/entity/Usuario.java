package com.vzorzanelli.reusa.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TUSUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "CPF", length = 11)
    private String cpf;

    @Column(name = "DATA_NASCIMENTO")
    private Date dataNascimento;

    @Column(name = "GENERO")
    @Enumerated(EnumType.STRING)
    private GeneroEnum genero;

    @Column(name = "REGISTRO_CLASSE")
    private String registroClasse;

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public GeneroEnum getGenero() {
        return genero;
    }

    public void setGenero(GeneroEnum genero) {
        this.genero = genero;
    }

    public String getRegistroClasse() {
        return registroClasse;
    }

    public void setRegistroClasse(String registroClasse) {
        this.registroClasse = registroClasse;
    }

}
