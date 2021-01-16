package com.vzorzanelli.reusa.repository;

import com.vzorzanelli.reusa.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "SELECT u FROM Usuario u " +
            " left join Usuario r on r = u.responsavel" +
            " WHERE u.nome like %?1% " +
            " OR u.cpf like %?1% " +
            " OR r.nome like %?1% " +
            " OR r.cpf like %?1% ")
    List<Usuario> findUsuarioByFiltro(String text);

}
