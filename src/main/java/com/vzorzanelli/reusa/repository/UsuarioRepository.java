package com.vzorzanelli.reusa.repository;

import com.vzorzanelli.reusa.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
