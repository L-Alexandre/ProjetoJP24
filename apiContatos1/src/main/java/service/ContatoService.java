package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import entity.Contato;
import repository.ContatoRepository;

import java.util.List;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    public List<Contato> listarContatos() {
        return contatoRepository.findAll();
    }

    public Contato buscarContatoPorId(Long id) {
        return contatoRepository.findById(id).orElse(null);
    }

    public Contato salvarContato(Contato contato) {
        return contatoRepository.save(contato);
    }

    public void deletarContato(Long id) {
        contatoRepository.deleteById(id);
 }
}