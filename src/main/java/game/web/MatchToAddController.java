package game.web;

import game.model.Match;
import game.model.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;

/**
 * Created by Michał on 2017-07-29.
 * Controller for adding matches page
 */

@Controller
@RequestMapping(value = "/addMatch")
public class MatchToAddController {

    private MatchService matchService;

    @Autowired
    public MatchToAddController(MatchService matchService) {
        this.matchService = matchService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String adminPage(Model model) {

        Match newMatch = new Match();
        model.addAttribute("newMatch", newMatch);
        return "addMatch";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processNote(@ModelAttribute("newMatch") Match newMatch, Model model) throws SQLException {

        matchService.addMatch(newMatch);
        return "redirect:/dashboard";
    }
}
