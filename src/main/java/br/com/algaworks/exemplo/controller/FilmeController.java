package br.com.algaworks.exemplo.controller;

import br.com.algaworks.exemplo.model.Filme;
import br.com.algaworks.exemplo.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @GetMapping("/{codigo}")
    public ResponseEntity<Filme> obterFilme(@PathVariable Long codigo) {
        if (codigo < 0) {
            return ResponseEntity.badRequest().build();
        }
        
        Filme filme = this.filmeService.obterFilme(codigo);

        if (filme == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(filme);
    }

}
