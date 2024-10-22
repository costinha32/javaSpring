package br.com.senai.service;

import br.com.senai.entity.Pessoa;
import br.com.senai.exception.EntidadeException;
import br.com.senai.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    public Pessoa cadastrarPessoa (Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> listaPessoa() {
        return pessoaRepository.findAll();
    }

    public Pessoa buscarPessoaPorID (Long id) {
        Pessoa pessoa = pessoaRepository.findById(id).orElseThrow(() -> new RuntimeException("Cadastro não encontrado. ID inválido"));
        return pessoa;
    }

    public List<Pessoa> buscarPessoaPorNome(String nomePessoa) {
        List<Pessoa> pessoas = new ArrayList<>();
        try {
            pessoas = pessoaRepository.buscarPessoaPorNome(nomePessoa);
            System.out.println(pessoas.get(1).getNome());
        } catch (EntidadeException entidade){
            System.out.println(entidade.getMessage());
        }
        return pessoaRepository.buscarPessoaPorNome(nomePessoa);
    }
    public void excluirPessoa (Long id) {
        pessoaRepository.deleteById(id);
    }
}