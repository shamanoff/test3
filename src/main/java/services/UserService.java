package services;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        users.addAll(userRepository.findAll());
        return users;
    }


    public User getById(String id) {
        return userRepository.findOne(id);
    }


    public List<User>  getByName(String name) {
        return userRepository.findByName(name);
    }


    public List<User>  getByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    public void delete(String id) {
        userRepository.delete(id);

    }


    public void saveUpdate(User user) {
        userRepository.save(user);
    }
}
