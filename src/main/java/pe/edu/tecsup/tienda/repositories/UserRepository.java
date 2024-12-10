package pe.edu.tecsup.tienda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import pe.edu.tecsup.tienda.entities.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByLastName(String lastName);

    List<User> findByState(Integer state);

    @Query("SELECT u FROM User u WHERE u.email=:email")
    UserDetails loadUserByUsername(@Param("email") String email);
}
