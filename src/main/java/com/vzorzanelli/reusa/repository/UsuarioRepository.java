package com.vzorzanelli.reusa.repository;

import com.vzorzanelli.reusa.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
