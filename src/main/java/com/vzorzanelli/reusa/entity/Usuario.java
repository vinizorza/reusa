package com.vzorzanelli.reusa.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TUSUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "CPF", length = 11, unique = true)
    private String cpf;

    @Column(name = "DATA_NASCIMENTO")
    private Date dataNascimento;

    @Column(name = "GENERO")
    @Enumerated(EnumType.STRING)
    private GeneroEnum genero;

    @Column(name = "REGISTRO_CLASSE")
    private String registroClasse;

    @ElementCollection(targetClass = PapelEnum.class)
    @CollectionTable(name = "TUSUARIO_PAPEL", joinColumns = @JoinColumn(name = "USUARIO_ID"))
    @Column(name = "PAPEL", nullable = false)
    @Enumerated(EnumType.STRING)
    private Collection<PapelEnum> papeis = new ArrayList<>();

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "RESPONSAVEL_USUARIO_ID")
    private Usuario responsavel;

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

    public Collection<PapelEnum> getPapeis() {
        return papeis;
    }

    public void setPapeis(Collection<PapelEnum> papeis) {
        this.papeis = papeis;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }
}
