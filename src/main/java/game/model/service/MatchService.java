package game.model.service;

import game.model.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Michał on 2017-07-29.
 * Service for MatchToAddController
 */

@Service
public class MatchService {

    private DataSource dataSource;

    @Autowired
    public MatchService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * Method connects with database and put there data
     * @param matchToAdd - data provided by user in form
     */
    public void addMatch(Match matchToAdd) throws SQLException{

        Connection connection = dataSource.getConnection();

        String insert = "INSERT INTO matches (day_number, home_team, away_team, home_goals, away_goals, note)" +
                        " VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement pstat = connection.prepareStatement(insert);
        pstat.setInt(1 ,matchToAdd.getDayNumber());
        pstat.setString(2, matchToAdd.getHomeTeam());
        pstat.setString(3, matchToAdd.getAwayTeam());
        pstat.setInt(4, matchToAdd.getHomeGoals());
        pstat.setInt(5, matchToAdd.getAwayGoals());
        pstat.setString(6, matchToAdd.getNote());
        pstat.executeUpdate();
    }
}
