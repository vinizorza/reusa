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

    public UsuarioDTO getUsuario(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.map(UsuarioDTO::from).orElse(null);
    }

    public void save(UsuarioDTO usuarioDTO) {
        usuarioRepository.save(UsuarioDTO.from(usuarioDTO));
    }
}
