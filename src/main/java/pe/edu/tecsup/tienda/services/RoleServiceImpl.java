package pe.edu.tecsup.tienda.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.tecsup.tienda.entities.Role;
import pe.edu.tecsup.tienda.repositories.RoleRepository;

import java.util.List;

@Slf4j
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> findAll() {
        log.info("RoleServiceImpl.findAll()");

        return roleRepository.findAll();
    }
}
