package com.vzorzanelli.reusa.repository;

import com.vzorzanelli.reusa.entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    @Query(value = "SELECT c FROM Consulta c WHERE c.paciente.id = ?1")
    List<Consulta> findByPacienteId(Long pacienteId);

}
