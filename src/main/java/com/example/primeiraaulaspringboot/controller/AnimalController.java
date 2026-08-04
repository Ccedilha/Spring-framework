package com.example.primeiraaulaspringboot.controller;

import com.example.primeiraaulaspringboot.model.AnimalModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/animal")
public class AnimalController {
    private final ArrayList<AnimalModel> animais = new ArrayList<>();

    @GetMapping("/listaAnimais")
    public ArrayList<AnimalModel> listaAnimais(){
        return animais;
    }

    @PostMapping("/adicionarAnimal")
    public AnimalModel adicionarAnimal(@RequestBody AnimalModel novoAnimal){
        animais.add(novoAnimal);
        return novoAnimal;
    }

    @PutMapping("atualizarAnimal/{nomeAnimal}")
    public AnimalModel atualizarAnimal(
            @PathVariable String nomeAnimal,
            @RequestBody AnimalModel animalAtualizado
    ){
        for (int i = 0; i < animais.size(); i++){
            AnimalModel animalAtual = animais.get(i);
            if (animalAtual.getNome().equals(nomeAnimal)){
                animalAtual.setNome(animalAtualizado.getNome());
                animalAtual.setEspecie(animalAtualizado.getEspecie());
                animalAtual.setRaca(animalAtualizado.getRaca());
                animalAtual.setIdade(animalAtualizado.getIdade());
                return animalAtual;
            }
        }
        return null;
    }

    @DeleteMapping("/deletarAnimal/{nomeAnimal}")
    public  String deletarAnimal(@PathVariable String nomeAnimal){
        for(int i = 0; i < animais.size(); i++){
            AnimalModel animalAtual = animais.get(i);
            if (animalAtual.getNome().equals(nomeAnimal)){
                animais.remove(i);
                return  "Animal excluído com sucesso.";
            }
        }

        return null;
    }
}
