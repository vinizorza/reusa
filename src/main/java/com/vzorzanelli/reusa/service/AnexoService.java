package com.vzorzanelli.reusa.service;
import com.vzorzanelli.reusa.entity.Anexo;
import com.vzorzanelli.reusa.repository.AnexoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Service
public class AnexoService {

    @Autowired
    AnexoRepository anexoRepository;

    public void salvarAnexo(MultipartFile arquivo) throws IOException {
        Anexo anexo = new Anexo();
        anexo.setNome(arquivo.getName());
        anexo.setArquivo(arquivo.getBytes());
        anexo.setTipo(arquivo.getContentType());
        anexoRepository.save(anexo);
    }

    public Anexo getArquivo(Long id){
        return anexoRepository.getOne(id);
    }

}
