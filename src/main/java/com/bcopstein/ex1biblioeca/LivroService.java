package com.bcopstein.ex1biblioeca;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LivroService {
    private final LivroRepository repository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public List<Livro> getListaLivros() {
        return repository.getListaLivros();
    }

    public List<String> getListaAutores() {
        return repository.getListaAutores();
    }

    public List<String> getListaTitulos() {
        return repository.getListaTitulos();
    }

    public List<Livro> getLivroAno(int ano) {
        return repository.getLivroAno(ano);
    }

    public List<Livro> getDesatualizados(int ano) {
        return repository.getDesatualizados(ano);
    }

    public List<Livro> addLivro(Livro livro) {
        return repository.addLivro(livro);
    }

    public List<Livro> mudarLivro(int codigo, Livro livro) {
        return repository.mudarLivro(codigo, livro);
    }

    public List<Livro> deletarLivro(int id) {
        return repository.deletarLivro(id);
    }
}