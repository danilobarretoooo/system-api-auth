package danilobarreto.dev.systemapiauth.security;

import danilobarreto.dev.systemapiauth.model.User;
import danilobarreto.dev.systemapiauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail).orElseThrow(() -> new UsernameNotFoundException("Nenhum usuário encontrado com este nome: "+ usernameOrEmail));
        return UserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserById(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("Nenhum usuário encontrado com o ID: "+ id));
        return UserPrincipal.create(user);
    }
}
