package game.web;

import com.fasterxml.jackson.annotation.JsonView;
import game.model.*;
import game.model.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Created by Michał on 2017-08-01.
 * Rest controller for dashboard purposes.
 */

@RestController
public class DashboardAjaxController {

    private List<Match> matches;

    @Autowired
    public DashboardService dashboardService;

    /**
     * Method used for finding matches.
     * @param criteria - input from form
     * @return - JSON with list of matches
     */
    @JsonView(Views.Public.class)
    @RequestMapping(value = { "/searchMatches"})
    public AjaxFoundMatchesResponseBody findMatches(@RequestBody MatchesSearchingCriteria criteria) throws SQLException {

        AjaxFoundMatchesResponseBody result = new AjaxFoundMatchesResponseBody();

        if (Optional.ofNullable(criteria).isPresent()) {

            List<Match> matches = findMatchesByCriteria(criteria.getNumber());

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
    public AjaxFoundNoteResponseBody findNote(@RequestBody NoteSearchingCriteria criteria) throws SQLException {

        AjaxFoundNoteResponseBody result = new AjaxFoundNoteResponseBody();

        if (Optional.ofNullable(criteria).isPresent()) {

            String note = getNoteByCriteria(criteria.getPosition());

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
