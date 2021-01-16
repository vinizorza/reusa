package com.vzorzanelli.reusa.dto;

import com.vzorzanelli.reusa.entity.GeneroEnum;
import com.vzorzanelli.reusa.entity.Usuario;

import javax.persistence.Column;
import java.util.Date;

public class UsuarioDTO {

    private Long id;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private GeneroEnum genero;
    private String registroClasse;

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

    public static UsuarioDTO from(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setCpf(usuario.getCpf());
        dto.setGenero(usuario.getGenero());
        dto.setNome(usuario.getNome());
        dto.setDataNascimento(usuario.getDataNascimento());
        dto.setRegistroClasse(usuario.getRegistroClasse());
        return dto;
    }

    public static Usuario from(UsuarioDTO dto) {
        Usuario entity = new Usuario();
        entity.setCpf(dto.getCpf());
        entity.setGenero(dto.getGenero());
        entity.setNome(dto.getNome());
        entity.setDataNascimento(dto.getDataNascimento());
        entity.setRegistroClasse(dto.getRegistroClasse());
        return entity;
    }
}
