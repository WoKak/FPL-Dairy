package game.service;

import game.model.Match;
import game.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michał on 2017-08-01.
 * Service for RestDashboardController
 */

@Service
public class DashboardService {

    private MatchRepository matchRepository;

    @Autowired
    public DashboardService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    /**
     * Finds list of matches by criteria.
     * @param criteria - data provided by user in dashboard form
     * @return - list of matching matches
     */
    public List<Match> findMatchesByCriteria(String criteria) throws SQLException{

        return matchRepository.findMatchesByCriteria(criteria);
    }

    /**
     * Finds note from previous found matches.
     * @param position - which match was selected
     * @param matches - previous list
     * @return - note from selected match
     */
    public String findNoteByCriteria(String position, List<Match> matches) {

        String tmp = position.substring(position.length() - 1);
        return matches.get(Integer.parseInt(tmp)).getNote();
    }
}
