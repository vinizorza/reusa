package com.vzorzanelli.reusa.controller;

import com.vzorzanelli.reusa.entity.Anexo;
import com.vzorzanelli.reusa.service.AnexoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping(value = "/anexo")
public class AnexoController {

    @Autowired
    AnexoService anexoService;

    @PostMapping("/upload")
    public void uploadArquivo(@RequestParam MultipartFile file) throws IOException {
        anexoService.salvarAnexo(file);
    }

    @RequestMapping(value="/download/{id}", method= RequestMethod.GET)
    public ResponseEntity<Resource> getArquivo(@PathVariable("id") Long id){
        Anexo anexo = anexoService.getArquivo(id);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(anexo.getTipo()))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename= " + anexo.getNome())
                .body(new ByteArrayResource(anexo.getArquivo()));
    }

}