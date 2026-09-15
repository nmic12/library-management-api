package com.bcopstein.ex1biblioeca;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class LivroRepository {
    private List<Livro> livros;

    public LivroRepository() {
        livros = new LinkedList<>();
        livros.add(new Livro(100, "Aprendendo Spring-Boot", "Huguinho Pato", 2020));
        livros.add(new Livro(120, "Aprendendo Java", "Zezinho Pato", 2015));
        livros.add(new Livro(140, "Aprendendo Outra coisa", "Luizinho Pato", 2023));
        livros.add(new Livro(140, "Aprendendo Uma coisa nova", "Huguinho Pato", 2023));
        livros.add(new Livro(140, "Aprendendo Outra coisa nova", "Huguinho Pato", 2023));
    }

    public String mensagemDeBemVindo() {
        return "Bem vindo a biblioteca central!";
    }

    public List<Livro> getListaLivros() {
        return livros;
    }

    public List<String> getListaAutores() {
        return livros.stream()
                .map(l -> l.getAutor())
                .distinct()
                .toList();
    }

    public List<String> getListaTitulos() {
        return livros.stream()
                .map(l -> l.getTitulo())
                .toList();
    }

    public List<Livro> getLivroAno(int ano) {
        return livros.stream()
                .filter(l -> l.getAno() == ano)
                .toList();
    }

    public List<Livro> getDesatualizados(int ano) {
        return livros.stream()
                .filter(l -> l.getAno() < ano)
                .toList();
    }

    public List<Livro> addLivro(Livro livro) {
        livros.add(livro);
        return livros;
    }

    public List<Livro> mudarLivro(int codigo, Livro livroNovo) {
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).getId() == codigo) {
                livros.set(i, livroNovo);
                break;
            }
        }

        return livros;
    }
    public List<Livro> deletarLivro(int id) {
        livros.removeIf(livro -> livro.getId() == id);
        return livros;
    }
}