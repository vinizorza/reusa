package com.vzorzanelli.reusa.dto;

import com.vzorzanelli.reusa.entity.Consulta;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConsultaDTO {

    private Long id;
    private Date dataCriacao;
    private Date dataModificacao;
    private String sintomas;
    private String diagnostico;
    private String tratamento;
    private UsuarioDTO paciente;
    private UsuarioDTO medico;

    public static List<ConsultaDTO> from(List<Consulta> entities) {
        List<ConsultaDTO> dtos = new ArrayList<>();
        for(Consulta entity: entities){
            dtos.add(ConsultaDTO.from(entity));
        }
        return dtos;
    }

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

    public UsuarioDTO getPaciente() {
        return paciente;
    }

    public void setPaciente(UsuarioDTO paciente) {
        this.paciente = paciente;
    }

    public UsuarioDTO getMedico() {
        return medico;
    }

    public void setMedico(UsuarioDTO medico) {
        this.medico = medico;
    }

    public static ConsultaDTO from(Consulta entity) {
        ConsultaDTO dto = new ConsultaDTO();
        dto.setId(entity.getId());
        dto.setDataCriacao(entity.getDataCriacao());
        dto.setDiagnostico(entity.getDiagnostico());
        dto.setDataModificacao(entity.getDataModificacao());
        dto.setMedico(UsuarioDTO.from(entity.getMedico()));
        dto.setPaciente(UsuarioDTO.from(entity.getPaciente()));
        dto.setSintomas(entity.getSintomas());
        dto.setTratamento(entity.getTratamento());
        return dto;
    }

    public static Consulta from(ConsultaDTO dto) {
        Consulta entity = new Consulta();
        entity.setId(dto.getId());
        entity.setDataCriacao(dto.getDataCriacao());
        entity.setDiagnostico(dto.getDiagnostico());
        entity.setDataModificacao(dto.getDataModificacao());
        entity.setMedico(UsuarioDTO.from(dto.getMedico()));
        entity.setPaciente(UsuarioDTO.from(dto.getPaciente()));
        entity.setSintomas(dto.getSintomas());
        entity.setTratamento(dto.getTratamento());
        return entity;
    }
}
