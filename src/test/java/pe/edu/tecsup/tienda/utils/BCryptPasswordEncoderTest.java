package pe.edu.tecsup.tienda.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Slf4j
@SpringBootTest
public class BCryptPasswordEncoderTest {

    @Test
    void testCreateBCryptPassword() {
        // Create an instance of BCryptPasswordEncoder
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // Encode password
        String rawPassword = "123456";
        String encodedPassword = passwordEncoder.encode(rawPassword);

        log.info("Raw password: {}", rawPassword);
        log.info("Encoded password: {}", encodedPassword);

        // Check if a provided password matches the encoded password
        boolean matches = passwordEncoder.matches(rawPassword, encodedPassword);

        log.info("Passwords match: {}", matches);
    }
}
