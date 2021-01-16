package com.vzorzanelli.reusa.dto;

import com.vzorzanelli.reusa.entity.GeneroEnum;
import com.vzorzanelli.reusa.entity.PapelEnum;
import com.vzorzanelli.reusa.entity.Usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsuarioDTO {

    private Long id;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private GeneroEnum genero;
    private String registroClasse;
    private List<PapelEnum> papeis = new ArrayList<>();
    private UsuarioDTO responsavel;

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

    public List<PapelEnum> getPapeis() {
        return papeis;
    }

    public void setPapeis(List<PapelEnum> papeis) {
        this.papeis = papeis;
    }

    public UsuarioDTO getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(UsuarioDTO responsavel) {
        this.responsavel = responsavel;
    }

    public static UsuarioDTO from(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setCpf(usuario.getCpf());
        dto.setGenero(usuario.getGenero());
        dto.setNome(usuario.getNome());
        dto.setDataNascimento(usuario.getDataNascimento());
        dto.setRegistroClasse(usuario.getRegistroClasse());

        if(usuario.getResponsavel() != null)
            dto.setResponsavel(UsuarioDTO.from(usuario.getResponsavel()));

        for(PapelEnum papel: usuario.getPapeis()){
            dto.getPapeis().add(papel);
        }

        return dto;
    }

    public static Usuario from(UsuarioDTO dto) {
        Usuario entity = new Usuario();
        entity.setId(dto.getId());
        entity.setCpf(dto.getCpf());
        entity.setGenero(dto.getGenero());
        entity.setNome(dto.getNome());
        entity.setDataNascimento(dto.getDataNascimento());
        entity.setRegistroClasse(dto.getRegistroClasse());

        if(dto.getResponsavel() != null)
            entity.setResponsavel(UsuarioDTO.from(dto.getResponsavel()));

        for(PapelEnum papel: dto.getPapeis()){
            entity.getPapeis().add(papel);
        }

        return entity;
    }

    public static List<UsuarioDTO> from(List<Usuario> entities) {
        List<UsuarioDTO> dtos = new ArrayList<>();
        for (Usuario entity: entities) {
            dtos.add(UsuarioDTO.from(entity));
        }
        return dtos;
    }
}
