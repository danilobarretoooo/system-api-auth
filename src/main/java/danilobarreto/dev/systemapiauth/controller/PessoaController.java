package danilobarreto.dev.systemapiauth.controller;

import danilobarreto.dev.systemapiauth.model.Pessoa;
import danilobarreto.dev.systemapiauth.model.enums.Cargo;
import danilobarreto.dev.systemapiauth.model.records.NewPeople;
import danilobarreto.dev.systemapiauth.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;


    @GetMapping("/cargos")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Cargo> getCargos() {
        return Arrays.asList(Cargo.values());
    }

    @PostMapping("/cadastrar")
    @PreAuthorize("hasRole('ADMIN')")
    public String cadastrarFuncionario(@Valid @RequestBody NewPeople newPeople) {
        pessoaService.cadastraPessoas(newPeople);
        return "Funcionário cadastrado com sucesso!";
    }

    @GetMapping("/listar")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Pessoa> listarFuncionarios() {
        return pessoaService.listaTodos();
    }

    @PutMapping("/alterar")
    @PreAuthorize("hasRole('ADMIN')")
    public Pessoa update(@RequestBody Pessoa pessoa){return pessoaService.createOrUpdate(pessoa);}

    @DeleteMapping("/deletar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deletarFuncionario(@PathVariable Long id){
        pessoaService.deletarPessoa(id);
    }
}
