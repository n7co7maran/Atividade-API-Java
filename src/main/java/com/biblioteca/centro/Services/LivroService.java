package com.biblioteca.centro.Services;

import com.biblioteca.centro.Entities.LivroEntity;
import com.biblioteca.centro.Repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public void criarLivro(LivroEntity livro){
      livroRepository.save(livro);
    };

    public List<LivroEntity> listarLivros(){
        return livroRepository.findAll();
    }

    public LivroEntity listarLivro(Long id){
        return livroRepository.findById(id).orElse(null);
    }

    public void atualizarLivro(LivroEntity livro, Long id){
        LivroEntity newLivro = livroRepository.findById(id).orElse(null);

        if(newLivro != null){
            newLivro.setNome(livro.getNome());
            newLivro.setPaginas(livro.getPaginas());

            livroRepository.save(newLivro);
        }
    }

    public void deletarLivro(Long id){
        var newLivro = livroRepository.findById(id);

        if(newLivro.isPresent()){
            livroRepository.deleteById(id);
        }
    }
}
