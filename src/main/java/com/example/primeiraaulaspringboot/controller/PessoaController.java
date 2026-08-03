package com.example.primeiraaulaspringboot.controller;

import com.example.primeiraaulaspringboot.model.PessoaModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

// Essa classe Controller é responsavel por fazer requisições web e devolver respostas
//Por padrão, essas respostas são em formato de texto JSON

/**
 * Requisições HTTP:
 *  GET -> Ler -> Solicita dados específicos no servidor.
 *  POST -> Criar -> Envia dados para o servidor.
 *  PUT -> Subsitui -> Atualiza algum dado no meu servidor
 *  DELETE -> Apaga -> Remove algum recurso do servidor.
 */

@RestController // Anotação que permite esta classe fazer requisições HTTP
@RequestMapping("/pessoa") // Toda vez que for acessar um metodo da classe PessoaControler, precia colocar um /pessoa antes de chamar seu outro Mapping
public class PessoaController {
    //lista que vai guardar todos os nossos objetos da classe PessoaModel
    private final ArrayList<PessoaModel> pessoas = new ArrayList<>();

    //localhost:8080/pessoa/listaPessoas
    @GetMapping("/listaPessoas") // Faz requisições GET, nesse caso, mostrando os valores dentro da lista pessoas
    public ArrayList<PessoaModel> listaPessoas(){
        return pessoas;
    }

    //localhost:8080/pessoa/adicionarPessoa
    @PostMapping("/adicionarPessoa") // Envia uma requisição POST, adicionando um novo valor dentro da lista pessoas
    public PessoaModel adicionarPessoa(@RequestBody PessoaModel novaPessoa){
        pessoas.add(novaPessoa);
        return novaPessoa;
    }

    //localhost:8080/pessoa/atualizarPessoa/{nome}
    @PutMapping("atualizarPessoa/{nomePessoa}")
    public PessoaModel atualizarPessoa(
            @PathVariable String nomePessoa,
            @RequestBody PessoaModel pessoaAtualizada
    ){
        for (int i = 0; i < pessoas.size(); i++) {
            PessoaModel pessoaAtual = pessoas.get(i);
            if (pessoaAtual.getNome().equals(nomePessoa)) {
                pessoaAtual.setNome(pessoaAtualizada.getNome());
                pessoaAtual.setIdade(pessoaAtualizada.getIdade());
                pessoaAtual.setCidadeNascimento(pessoaAtualizada.getCidadeNascimento());
                return pessoaAtual;
            }
        }
        return null;
    }

    //localhost:8080//deletarPessoa/{nomePessoa}
    @DeleteMapping("/deletarPessoa/{nomePessoa}")
    public String deletarPessoa(@PathVariable String nomePessoa){
        for (int i = 0; i < pessoas.size(); i++) {
            PessoaModel pessoaAtual = pessoas.get(i);
            if (pessoaAtual.getNome().equals(nomePessoa)){
                pessoas.remove(i);
                return "Pessoa excluida com sucesso.";
            }
        }

        return null;
    }


}