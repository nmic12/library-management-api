package com.bcopstein.ex1biblioeca;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    // private List<Livro> livros;
    @Autowired
    private LivroRepository repository;

    @GetMapping("")
    @CrossOrigin(origins = "*")
    public String mensagemDeBemVindo() {
        return "Bem vindo a biblioteca central!";
    }

    @GetMapping("livros")
    @CrossOrigin(origins = "*")
    public List<Livro> getListaLivros() {
        return repository.getListaLivros();
    }

    @GetMapping("autores")
    @CrossOrigin(origins = "*")
    public List<String> getListaAutores() {
        return repository.getListaAutores();
    }

    @GetMapping("titulos")
    @CrossOrigin(origins = "*")
    public List<String> getListaTitulos() {
        return repository.getListaTitulos();
    }

    @GetMapping("livroporano/{ano}")
    public List<Livro> getLivroAno(@PathVariable int ano) {
        return repository.getLivroAno(ano);
    }

    @GetMapping("/desatualizados/{ano}")
    public List<Livro> getDesatualizados(@PathVariable int ano) {
        return repository.getDesatualizados(ano);
    }

    @PostMapping("/livro")
    public List<Livro> addLivro(@RequestBody Livro l) {
        return repository.addLivro(l);
    }

    @PutMapping("/livros/{codigo}")
    public List<Livro> mudarLivro(@PathVariable int codigo, @RequestBody Livro l) {
        return repository.mudarLivro(codigo, l);
    }

    @DeleteMapping("/livros/{codigo}")
    public List<Livro> deletarLivro(@PathVariable int codigo) {
        return repository.deletarLivro(codigo);
    }
}