package game.web;

import game.domain.Match;
import game.domain.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;

/**
 * Created by Michał on 2017-07-29.
 */

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    public MatchService matchService;

    @RequestMapping(method = RequestMethod.GET)
    public String adminPage(Model model) {

        Match newMatch = new Match();
        model.addAttribute("newMatch", newMatch);
        return "admin";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processNote(@ModelAttribute("newMatch") Match newMatch, Model model) throws SQLException {

        matchService.addMatch(newMatch);
        return "redirect:/dashboard";
    }
}
