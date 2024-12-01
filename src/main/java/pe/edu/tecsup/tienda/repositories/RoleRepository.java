package pe.edu.tecsup.tienda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.tecsup.tienda.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
