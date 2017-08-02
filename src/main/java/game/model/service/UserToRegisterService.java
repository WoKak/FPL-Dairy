package game.model.service;

import game.model.UserToRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

/**
 * Created by Michał on 2017-07-26.
 */

@Service
public class UserToRegisterService {

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Autowired
    private DataSource dataSource;

    /**
     * method responsible for registering user - in typical way (first user into users, then question into questions)
     */
    public void addUser(UserToRegister newUserToRegister, BindingResult bindingResult) throws Exception {



            if (Optional.ofNullable(bindingResult).isPresent())
                if (bindingResult.hasErrors()) {
                    throw new IllegalArgumentException("Błędne dane formularza");
                }

            Connection connection = dataSource.getConnection();


            String query = "SELECT * FROM users WHERE username=?";
            PreparedStatement checkStat = connection.prepareStatement(query);
            checkStat.setString(1, newUserToRegister.getLogin());
            ResultSet result = checkStat.executeQuery();

            //checks whether user exists
            if (result.next()) {
                throw new IllegalStateException("Użytkownik istnieje");
            }

            //password equals repeated password
            if (!newUserToRegister.getPassword().equals(newUserToRegister.getRepeatedPassword())) {
                throw new IllegalArgumentException("Błędne dane formularza");
            }

            String insertUsers = "INSERT INTO users (username, password, enabled) VALUES (?, ?, true)";

            String hash = passwordEncoder.encode(newUserToRegister.getPassword());

            PreparedStatement pstat1 = connection.prepareStatement(insertUsers);
            pstat1.setString(1, newUserToRegister.getLogin());
            pstat1.setString(2, hash);
            pstat1.executeUpdate();

            String insertRoles = "INSERT INTO user_roles (username, role) VALUES (?, 'ROLE_USER')";
            PreparedStatement pstat2 = connection.prepareStatement(insertRoles);
            pstat2.setString(1, newUserToRegister.getLogin());
            pstat2.executeUpdate();
    }
}
