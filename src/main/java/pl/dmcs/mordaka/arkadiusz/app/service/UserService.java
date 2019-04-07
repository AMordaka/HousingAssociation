package pl.dmcs.mordaka.arkadiusz.app.service;

import pl.dmcs.mordaka.arkadiusz.app.model.DTO.UserLocalDTO;
import pl.dmcs.mordaka.arkadiusz.app.model.User;

import java.util.List;

public interface UserService {

    User findById(Integer id);

    User findByLogin(String login);

    void registerUser(User user);

    String getPrincipal();

    List<User> getAllUsers();

    void assignUserToLocal(UserLocalDTO dto);
}
