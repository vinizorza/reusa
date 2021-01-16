package com.vzorzanelli.reusa.controller;

import com.vzorzanelli.reusa.dto.UsuarioDTO;
import com.vzorzanelli.reusa.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public UsuarioDTO getMaterial(@PathVariable("id") Long id){
        return usuarioService.getUsuario(id);
    }

    @RequestMapping(method= RequestMethod.PUT)
    public UsuarioDTO getMaterial(@RequestBody UsuarioDTO usuarioDTO){
        return usuarioService.save(usuarioDTO);
    }

}
