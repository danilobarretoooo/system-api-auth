package danilobarreto.dev.systemapiauth.repository;

import danilobarreto.dev.systemapiauth.model.Role;
import danilobarreto.dev.systemapiauth.model.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);

}
