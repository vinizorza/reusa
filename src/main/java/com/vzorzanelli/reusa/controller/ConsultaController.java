package com.vzorzanelli.reusa.controller;

import com.vzorzanelli.reusa.dto.ConsultaDTO;
import com.vzorzanelli.reusa.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/consulta")
public class ConsultaController {

    @Autowired
    ConsultaService consultaService;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ConsultaDTO getConsulta(@PathVariable("id") Long id){
        return consultaService.getConsulta(id);
    }

    @RequestMapping(value="/usuario/{id}", method= RequestMethod.GET)
    public List<ConsultaDTO> listarConsultasByUsuario(@PathVariable("id") Long id){
        return consultaService.listarConsultasByUsuario(id);
    }

    @RequestMapping(method= RequestMethod.PUT)
    public void criarConsulta(@RequestBody ConsultaDTO consultaDTO){
        consultaService.criarConsulta(consultaDTO);
    }

    @RequestMapping(method= RequestMethod.POST)
    public void alterarConsulta(@RequestBody ConsultaDTO consultaDTO){
        consultaService.alterarConsulta(consultaDTO);
    }

    @RequestMapping(value = "/{id}", method= RequestMethod.DELETE)
    public void removerConsulta(@PathVariable("id") Long id){
        consultaService.removerConsulta(id);
    }

}
