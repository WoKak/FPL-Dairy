package game.web;

import com.fasterxml.jackson.annotation.JsonView;
import game.domain.Match;
import game.domain.SearchCriteria;
import game.domain.service.DashboardService;
import game.domain.AjaxResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Michał on 2017-08-01.
 */

@RestController
public class AjaxController {

    List<Match> matches;

    @Autowired
    public DashboardService dashboardService;

    @JsonView(Views.Public.class)
    @RequestMapping(value = { "/search"})
    public AjaxResponseBody defaultPage(@RequestBody SearchCriteria criteria) throws SQLException {

        AjaxResponseBody result = new AjaxResponseBody();

        if (Optional.ofNullable(criteria).isPresent()) {

            List<Match> matches = findMatchesByCriteria(criteria.getNumber());

            if (matches.size() > 0) {

                result.setMatches(matches);
            }
        }

        return result;
    }

    private List<Match> findMatchesByCriteria(String criteria) throws SQLException{

        matches = new ArrayList<>();

        matches = dashboardService.findMatchesByCriteria(criteria);

        return matches;
    }
}
