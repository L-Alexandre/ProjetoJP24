package dto;

import org.springframework.boot.SpringApplication;
import entity.Pessoa;

public record PessoaDTO(Long id, String nome, String malaDireta) {
    public PessoaDTO(Pessoa pessoa) {
        this(
            pessoa.getId(),
            pessoa.getNome(),
            String.format("%s, %s - CEP: %s - %s/%s",
                pessoa.getEndereco(),
                pessoa.getCep(),
                pessoa.getCidade(),
                pessoa.getUf()
            )
        );
    }
}
