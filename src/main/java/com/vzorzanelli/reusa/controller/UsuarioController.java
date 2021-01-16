package com.vzorzanelli.reusa.controller;

import com.vzorzanelli.reusa.dto.UsuarioDTO;
import com.vzorzanelli.reusa.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public UsuarioDTO getUsuario(@PathVariable("id") Long id){
        return usuarioService.getUsuario(id);
    }

    @RequestMapping(value="/findByFitro/{filtro}", method= RequestMethod.GET)
    public List<UsuarioDTO> findUsuarioByFiltro(@PathVariable("filtro") String filtro){
        return usuarioService.findUsuarioByFiltro(filtro);
    }

    @RequestMapping(method= RequestMethod.PUT)
    public void saveUsuario(@RequestBody UsuarioDTO usuarioDTO){
        usuarioService.save(usuarioDTO);
    }

}
