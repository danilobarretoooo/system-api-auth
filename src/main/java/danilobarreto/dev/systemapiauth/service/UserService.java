package danilobarreto.dev.systemapiauth.service;

import danilobarreto.dev.systemapiauth.model.Role;
import danilobarreto.dev.systemapiauth.model.User;
import danilobarreto.dev.systemapiauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;


    public Set<Role> buscarPermissao (Long id){
        User user = userRepository.findById(id).get();
        return user.getRoles();
    }
}
