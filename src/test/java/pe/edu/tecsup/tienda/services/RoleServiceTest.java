package pe.edu.tecsup.tienda.services;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pe.edu.tecsup.tienda.entities.Role;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class RoleServiceTest {

    @Autowired
    RoleService roleService;

    @Test
    void findAll() {
        log.info("Testing RoleService.findAll()");

        List<Role> roles = roleService.findAll();
        assertNotNull(roles);
        assertFalse(roles.isEmpty());

        assertEquals(3, roles.size());
        log.info("Number of roles: {}", roles.size());

        assertTrue(roles.stream().anyMatch(role -> role.getName().equals("Administrador")));
        assertTrue(roles.stream().anyMatch(role -> role.getName().equals("Ventas")));
        assertTrue(roles.stream().anyMatch(role -> role.getName().equals("Almacen")));

        roles.forEach(System.out::println);
    }
}