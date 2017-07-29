package game.web;

import game.domain.UserToRegister;
import game.domain.service.UserToRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by Michał on 2017-07-26.
 */

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private UserToRegisterService userToRegisterService;

    @RequestMapping(method = RequestMethod.GET)
    public String getUserDataFromForm(Model model) {

        UserToRegister newUserToRegister = new UserToRegister();
        model.addAttribute("userToRegister", newUserToRegister);
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processAddNewUserForm
            (@ModelAttribute("userToRegister") @Valid UserToRegister newUserToRegister, BindingResult result) throws Exception{

        userToRegisterService.addUser(newUserToRegister, result);
        return "redirect:/login";
    }
}
