package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import entity.Pessoa;
import repository.PessoaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa criarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Optional<Pessoa> obterPessoaPorId(Long id) {
        return pessoaRepository.findById(id);
    }

    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    public Pessoa atualizarPessoa(Long id, Pessoa pessoaAtualizada) {
        Pessoa pessoa = pessoaRepository.findById(id).orElseThrow();
        pessoa.setNome(pessoaAtualizada.getNome());
        pessoa.setEndereco(pessoaAtualizada.getEndereco());
        pessoa.setCep(pessoaAtualizada.getCep());
        pessoa.setCidade(pessoaAtualizada.getCidade());
        pessoa.setUf(pessoaAtualizada.getUf());
        return pessoaRepository.save(pessoa);
    }

    public void deletarPessoa(Long id) {
        pessoaRepository.deleteById(id);
    }
}