package pe.edu.tecsup.tienda.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.tecsup.tienda.entities.User;
import pe.edu.tecsup.tienda.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(User user) {
        log.info("UserServiceImpl.save()");

        userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        log.info("UserServiceImpl.findAll()");

        return userRepository.findAll();
    }

    @Override
    public List<User> findByLastName(String lastName) {
        log.info("UserServiceImpl.findByName()");

        return userRepository.findByLastName(lastName);
    }

    @Override
    public List<User> findByState(Integer state) {
        log.info("UserServiceImpl.findByState()");

        return userRepository.findByState(state);
    }

    @Override
    public User findById(Long id) throws Exception {
        log.info("UserServiceImpl.findById()");

        Optional<User> user = userRepository.findById(id);

        if (user.isPresent())
            return user.get();
        else
            throw new Exception("User not found");
    }

    @Override
    public void update(User user) {
        log.info("UserServiceImpl.update()");

        userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        log.info("UserServiceImpl.deleteById()");

        userRepository.deleteById(id);
    }
}
