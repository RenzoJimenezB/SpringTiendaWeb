package pe.edu.tecsup.tienda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.tecsup.tienda.entities.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByLastName(String lastName);

    List<User> findByState(Integer state);
}
