package danilobarreto.dev.systemapiauth.service;

import danilobarreto.dev.systemapiauth.model.Pessoa;
import danilobarreto.dev.systemapiauth.model.records.NewPeople;
import danilobarreto.dev.systemapiauth.model.records.SignUpRequest;
import danilobarreto.dev.systemapiauth.repository.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;
    private AuthService authService;


    public List<Pessoa> listaTodos() {
        return pessoaRepository.findAllAtivos();
    }

    @Transactional
    public void cadastraPessoas(NewPeople newPeople) {
        Pessoa pessoas = new Pessoa(null,
                newPeople.nome(),
                newPeople.telefone(),
                newPeople.funcao()
        );
        pessoaRepository.save(pessoas);
        SignUpRequest signUpRequest = new SignUpRequest(
                newPeople.nome(),
                newPeople.username(),
                newPeople.email(),
                newPeople.senha()
        );
        authService.cadastro(signUpRequest);
    }

    public Pessoa createOrUpdate(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @Transactional
    public void deletarPessoa(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
        pessoa.setExcluido("S");
        pessoaRepository.save(pessoa);
    }
}
