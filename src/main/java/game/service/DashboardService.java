package game.service;

import game.model.Match;
import game.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
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
     * @return - note from selected match
     */
    public String findNoteByCriteria(String position) {

        return matchRepository.findNote(position.substring(position.length() - 1));
    }
}
