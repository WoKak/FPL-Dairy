package game.service;

import game.model.Match;
import game.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * Created by Michał on 2017-07-29.
 * Service for MatchToAddController
 */

@Service
public class MatchService {

    private MatchRepository matchRepository;

    @Autowired
    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    /**
     * Method which calls repository method which put data in db
     * @param matchToAdd - data provided by user in form
     */
    public void addMatch(Match matchToAdd) throws SQLException{

        matchRepository.addMatch(matchToAdd);
    }
}
