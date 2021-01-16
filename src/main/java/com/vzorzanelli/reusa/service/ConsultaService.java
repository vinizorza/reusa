package com.vzorzanelli.reusa.service;

import com.vzorzanelli.reusa.dto.ConsultaDTO;
import com.vzorzanelli.reusa.dto.UsuarioDTO;
import com.vzorzanelli.reusa.entity.Consulta;
import com.vzorzanelli.reusa.entity.Usuario;
import com.vzorzanelli.reusa.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    ConsultaRepository consultaRepository;

    /**
     * Regras:
     * 1. Apenas usuarios com perfis ADMIN e MEDICO podem visualizar qualquer consulta
     * 2. Usuarios com apenas o perfil PACIENTE poderá visualizar apenas suas consultas
     */
    public ConsultaDTO getConsulta(Long id) {
        Optional<Consulta> consulta = consultaRepository.findById(id);
        return consulta.map(ConsultaDTO::from).orElse(null);
    }

    /**
     * Regras:
     * 1. Apenas usuarios com perfis ADMIN e MEDICO podem listar consultas
     * 2. Usuarios com apenas o perfil PACIENTE poderá listar apenas suas consultas
     */
    public List<ConsultaDTO> listarConsultasByUsuario(Long id) {
        List<Consulta> consultas = consultaRepository.findByPacienteId(id);
        return ConsultaDTO.from(consultas);
    }

    public void criarConsulta(ConsultaDTO consultaDTO) {
        consultaRepository.save(ConsultaDTO.from(consultaDTO));
    }

    public void alterarConsulta(ConsultaDTO consultaDTO) {
        consultaRepository.save(ConsultaDTO.from(consultaDTO));
    }

    public void removerConsulta(Long id) {
        consultaRepository.deleteById(id);
    }
}
