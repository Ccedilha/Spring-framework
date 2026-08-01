package com.example.primeiraaulaspringboot.controller;

import com.example.primeiraaulaspringboot.model.PessoaModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    //lista que vai guardar todos objetos da classe PessoaModel
    private final ArrayList<PessoaModel> pessoas = new ArrayList<>();

    @GetMapping("/listaPessoas")
    public ArrayList<PessoaModel> listaPessoa(){
        return pessoas;
    }

    //localhost:8080/pessoa/adicionarPessoa
    @PostMapping("/adicionarPessoas")
    public PessoaModel adicionarPessoa(@RequestBody PessoaModel novaPessoa){
        pessoas.add(novaPessoa);
        return novaPessoa;
    }
}

