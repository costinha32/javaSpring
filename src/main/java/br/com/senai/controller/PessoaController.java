package br.com.senai.controller;

import br.com.senai.entity.Pessoa;
import br.com.senai.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;
    @GetMapping
    public List<String> listarNome(){
        List<String> nomes = new ArrayList<String>();
        nomes.add("Caio, ex bebado");
        nomes.add("Tiago o motorista de fuga");
        nomes.add("Tod");
        nomes.add("Hercules maguari");
        nomes.add("Gabriel.");
        return nomes;
    }

    @PostMapping
    public Pessoa cadastrarPessoa (@RequestBody Pessoa pessoa) {

        return pessoaService.cadastrarPessoa(pessoa);
    }
    @GetMapping("/listar")
    public List<Pessoa> listarPessoas() {
        return pessoaService.listaPessoa();
    }

    @GetMapping("/busca/{id}")
    public Pessoa buscarPessoaPorID(@PathVariable Long id) {
        return pessoaService.buscarPessoaPorID(id);
    }

    @GetMapping("/buscar/{nomePessoa}")
    public List<Pessoa> buscarPessoaPorNome (@PathVariable String nomePessoa) {
        return pessoaService.buscarPessoaPorNome(nomePessoa);
    }

    @DeleteMapping("/{id}")
    public void excluirPessoa (@PathVariable Long id) {
        pessoaService.excluirPessoa(id);
    }
}
