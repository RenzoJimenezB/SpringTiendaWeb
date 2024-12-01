package pe.edu.tecsup.tienda.services;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pe.edu.tecsup.tienda.entities.Role;
import pe.edu.tecsup.tienda.entities.User;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void save() throws Exception {
        log.info("Testing UserService.save()");

        List<User> users = userService.findAll();
        int totalBeforeInsert = users.size();

        User user = new User();

        Role role = new Role();
        role.setId(1L);
        user.setRole(role);

        user.setEmail("test@test.com");
        user.setPassword("123456");
        user.setName("test name");
        user.setLastName("test lastname");
        user.setSex("M");

//        LocalDate localDate = LocalDate.parse("2000-01-01");
        LocalDate localDate = LocalDate.of(2000, 1, 1);
        Date date = Date.valueOf(localDate);
        user.setBirthdate(date);

        user.setPhone("999999999");
        user.setAddress("Av Test 123");
        user.setState(1);

        userService.save(user);

        user = userService.findById(user.getId());
        System.out.printf("User saved in the DB:\n%s\n", user);

        users = userService.findAll();
        int totalAfterInsert = users.size();
        assertEquals(totalBeforeInsert + 1, totalAfterInsert);
    }

    @Test
    void findAll() {
        log.info("Testing UserService.findAll()");

        List<User> users = userService.findAll();
        assertNotNull(users);
        assertFalse(users.isEmpty());
        assertFalse(users.contains(null));

        users.forEach(System.out::println);
    }

    @Test
    void findByLastName() {
        log.info("Testing UserService.findByLastName()");

        List<User> users = userService.findByLastName("Benites");
        assertNotNull(users);
        assertFalse(users.isEmpty());
        assertFalse(users.contains(null));

        users.forEach(System.out::println);
    }

    @Test
    void findByState() {
        log.info("Testing UserService.findByState()");

        List<User> users = userService.findByState(1);
        assertNotNull(users);
        assertFalse(users.isEmpty());
        assertFalse(users.contains(null));

        System.out.printf("ESTADO: 1 - %d users\n", users.size());
        users.forEach(System.out::println);

        users = userService.findByState(0);
        assertNotNull(users);
        assertTrue(users.isEmpty());

        System.out.println("ESTADO: 0 - No users found");
    }

    @Test
    void findById() throws Exception {
        log.info("Testing UserService.findById()");

        String EXPECTED_NAME = "Erick";
        Long id = 1L;
        User user = userService.findById(id);

        assertNotNull(user);
        assertEquals(EXPECTED_NAME, user.getName());

        System.out.println(user);
    }

    @Test
    void update() throws Exception {
        log.info("Testing UserService.update()");

        Long id = 5L;
        String ORIGINAL_NAME = "Erick";
        String UPDATED_NAME = "Erick 2";

        User user = userService.findById(id);
        System.out.printf("Original user object: \n%s\n", user);

        user.setName(UPDATED_NAME);
        userService.update(user);

        User updatedUser = userService.findById(id);
        System.out.printf("Updated user's name: %s\n", updatedUser.getName());
        assertEquals(UPDATED_NAME, updatedUser.getName());

        updatedUser.setName(ORIGINAL_NAME);
        userService.update(updatedUser);

        User restoredUser = userService.findById(id);
        System.out.printf("Restored user's name: %s\n", restoredUser.getName());
        assertEquals(ORIGINAL_NAME, restoredUser.getName());
    }

    @Test
    void deleteById() {
        log.info("Testing UserService.deleteById()");

        List<User> users = userService.findAll();
        int totalBeforeDelete = users.size();

        if (users.isEmpty())
            return;

        User lastUser = users.get(users.size() - 1);
        userService.deleteById(lastUser.getId());

        System.out.printf("User deleted from the DB:\n%s\n", lastUser);

        users = userService.findAll();
        int totalAfterDelete = users.size();
        assertEquals(totalBeforeDelete - 1, totalAfterDelete);

    }
}