package game.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Michał on 2017-07-16.
 * Controller for dashboard page
 */

@Controller
@RequestMapping(value = { "/dashboard"})
public class DashboardController {

    @RequestMapping(method = RequestMethod.GET)
    public String defaultPage() {
        return "dashboard";
    }
}
