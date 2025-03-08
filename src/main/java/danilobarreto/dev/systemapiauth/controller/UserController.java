package danilobarreto.dev.systemapiauth.controller;

import danilobarreto.dev.systemapiauth.model.Role;
import danilobarreto.dev.systemapiauth.model.records.UserSummary;
import danilobarreto.dev.systemapiauth.repository.UserRepository;
import danilobarreto.dev.systemapiauth.security.CurrentUser;
import danilobarreto.dev.systemapiauth.security.UserPrincipal;
import danilobarreto.dev.systemapiauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserRepository repository;

    private final UserService service;

    @Autowired
    public UserController(UserRepository repository, UserService service) {
        this.repository = repository;
        this.service = service;
    }


    @GetMapping("/me")
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        return new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getName(), currentUser.getEmail());
    }

    @GetMapping("/permissao")
    public Set<Role> buscarPermissao(@CurrentUser UserPrincipal currentUser) {
        return service.buscarPermissao(currentUser.getId());
    }

}
