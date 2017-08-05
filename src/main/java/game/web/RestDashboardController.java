package game.web;

import com.fasterxml.jackson.annotation.JsonView;
import game.model.*;
import game.model.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Created by Michał on 2017-08-01.
 * Rest controller for dashboard purposes.
 */

@RestController
public class RestDashboardController {

    private List<Match> matches;

    private DashboardService dashboardService;

    @Autowired
    public RestDashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    /**
     * Method used for finding matches.
     * @param number - input from form
     * @return - JSON with list of matches
     */
    @JsonView(Views.Public.class)
    @RequestMapping(value = { "/searchMatches"})
    public FoundMatchesResponseBody findMatches(@RequestParam String number) throws SQLException {

        FoundMatchesResponseBody result = new FoundMatchesResponseBody();

        if (Optional.ofNullable(number).isPresent()) {

            List<Match> matches = findMatchesByCriteria(number);

            if (matches.size() > 0) {

                result.setMatches(matches);
            }
        }

        return result;
    }

    /**
     * Method used for finding matches in database.
     * @param criteria - input from form
     * @return - list of matching matches
     */
    private List<Match> findMatchesByCriteria(String criteria) throws SQLException{

        matches = dashboardService.findMatchesByCriteria(criteria);

        return matches;
    }

    /**
     * Finds note for clicked match.
     * @param criteria - which match was clicked
     * @return - JSON with note
     */
    @JsonView(Views.Public.class)
    @RequestMapping(value = { "/searchNote"})
    public FoundNoteResponseBody findNote(@RequestParam String position) throws SQLException {

        FoundNoteResponseBody result = new FoundNoteResponseBody();

        if (Optional.ofNullable(position).isPresent()) {

            String note = getNoteByCriteria(position);

            if (Optional.ofNullable(note).isPresent()) {

                result.setNote(note);
            }
        }

        return result;
    }

    /**
     * Finds note in database.
     * @param position - which match was clicked
     * @return - note
     */
    private String getNoteByCriteria(String position) {

        return dashboardService.findNoteByCriteria(position, matches);
    }
}
