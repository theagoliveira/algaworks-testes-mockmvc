package br.com.algaworks.exemplo.service;

import br.com.algaworks.exemplo.model.Filme;
import org.springframework.stereotype.Service;

@Service
public class FilmeService {

    public Filme obterFilme(Long codigo) {
        if (codigo > 100) {
            return null;
        }

        return new Filme(
                codigo,
                "O Poderoso Chefão",
                "Filme norte-americano de 1972, dirigido por Francis Ford Coppola"
        );
    }

}
