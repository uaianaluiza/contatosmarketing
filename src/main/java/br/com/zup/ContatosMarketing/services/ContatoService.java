package br.com.zup.ContatosMarketing.services;

import br.com.zup.ContatosMarketing.exceptions.ContatoNaoCadastradoException;
import br.com.zup.ContatosMarketing.models.Contato;
import br.com.zup.ContatosMarketing.repositories.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    public boolean verificarEmailJaCadastrado(String email) {
        Optional<Contato> contato = contatoRepository.findById(email);
        if ( contato.isPresent() ) {
            return true;
        } else {
            throw new ContatoNaoCadastradoException();
        }
    }

    public void cadastrarContato(Contato contato) {
        if (!verificarEmailJaCadastrado(contato.getEmail())) ;
        contatoRepository.save(contato);
    }

    public Contato buscarContatoPorEmail(String email) {
        Optional<Contato> contato = contatoRepository.findById(email);

        if ( contato.isPresent() ) {
            return contato.get();
        }
        throw new ContatoNaoCadastradoException();
    }

    public Iterable<Contato> verTodosOsContatos(Contato contato){
        Iterable<Contato> contatos = contatoRepository.findAll();
        return contatos;
    }
    public void deletarContato(String email){
        contatoRepository.deleteById(email);
    }
}
