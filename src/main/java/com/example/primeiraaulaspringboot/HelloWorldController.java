package com.example.primeiraaulaspringboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloWorldController {
    @GetMapping("/pessoa")
    public PessoaModel objetoPessoa(){
        return new PessoaModel("Ian",20,"Fortaleza");
    }

    @GetMapping("/")
    public String inicio(){
        return "oi";
    }
    @GetMapping("/olaComNome/{nome}")
    public String saudarComNome(@PathVariable String nome){
        return "Olá "+nome+", seja bem-vindo!";
    }

    PessoaModel pessoa = new PessoaModel("Ian", 20,"Fortaleza");
    @GetMapping("/olaComNomeInstacia")
    public String saudarComNomeInstancia(){
        return "";
    }
}
