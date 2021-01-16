package com.vzorzanelli.reusa.service;

import com.vzorzanelli.reusa.dto.UsuarioDTO;
import com.vzorzanelli.reusa.entity.Usuario;
import com.vzorzanelli.reusa.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    /**
     * Regras:
     * 1. Apenas perfis ADMIN e MEDICO pode visualizar perfil PACIENTE
     */
    public UsuarioDTO getUsuario(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.map(UsuarioDTO::from).orElse(null);
    }

    /**
     * Regras:
     * 1. Apenas perfil ADMIN pode criar usuario com perfil MEDICO
     * 2. Apenas perfis ADMIN e MEDICO pode criar perfil PACIENTE
     */
    public void save(UsuarioDTO usuarioDTO) {
        usuarioRepository.save(UsuarioDTO.from(usuarioDTO));
    }
}
