package com.example.primeiraaulaspringboot;
public class PessoaModel {
    private String nome;
    private int idade;
    private String cidadeNascimento;

    public PessoaModel(String nome, int idade, String cidadeNascimento) {
        this.nome = nome;
        this.idade = idade;
        this.cidadeNascimento = cidadeNascimento;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidadeNascimento() {
        return cidadeNascimento;
    }

    public void setCidadeNascimento(String cidadeNascimento) {
        this.cidadeNascimento = cidadeNascimento;
    }
}
