package game.service;

import game.model.UserToRegister;
import game.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

/**
 * Created by Michał on 2017-07-26.
 * Service for RegistrationController
 */

@Service
public class UserToRegisterService {


    private UserRepository userRepository;

    @Autowired
    public UserToRegisterService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    /**
     * method responsible for calling repository method for user registration
     */
    public void addUser(UserToRegister newUserToRegister, BindingResult bindingResult) throws Exception {

        userRepository.addUser(newUserToRegister, bindingResult);
    }
}
