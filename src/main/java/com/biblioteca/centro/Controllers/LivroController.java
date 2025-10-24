package com.biblioteca.centro.Controllers;

import com.biblioteca.centro.Entities.LivroEntity;
import com.biblioteca.centro.Services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public List<LivroEntity> listarLivros(){
        return livroService.listarLivros();
    }

    @GetMapping("/{id}")
    public LivroEntity listarLivro(@PathVariable Long id){
        return livroService.listarLivro(id);
    }

    @PostMapping
    public void criarLivro(@RequestBody LivroEntity livro){
        livroService.criarLivro(livro);
    }

    @PostMapping("/{id}")
    public void atualizarLivro(@RequestBody LivroEntity livro, @PathVariable Long id){
        livroService.atualizarLivro(livro, id);
    }

    @DeleteMapping("/{id}")
    public void deletarLivro(@PathVariable Long id){
        livroService.deletarLivro(id);
    }

}
