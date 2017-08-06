package game.repository;

import game.model.Match;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michał on 2017-08-06.
 * Class for db operations on matches
 */
public class MatchRepository {

    private DataSource dataSource;
    private ArrayList<Match> matches;

    @Autowired
    public MatchRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * Adds match to db
     * @param matchToAdd - match to add
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

    /**
     * Finds list of matches from particular day
     * @param criteria - day number provided in form
     * @return - list of matches
     */
    public List<Match> findMatchesByCriteria(String criteria) throws SQLException{

        matches = new ArrayList<>();

        Connection connection = dataSource.getConnection();

        String query = "SELECT * FROM matches WHERE day_number=?";
        PreparedStatement pstat = connection.prepareStatement(query);
        pstat.setInt(1, Integer.parseInt(criteria));
        ResultSet result = pstat.executeQuery();

        while (result.next()) {

            matches.add(new Match(
                    result.getInt(1),
                    result.getString(2),
                    result.getString(3),
                    result.getInt(4),
                    result.getInt(5),
                    result.getString(6)
            ));
        }

        ArrayList<Match> toReturn = matches;

        return toReturn;
    }

    /**
     * Finds requested note
     * @param position - information which match was clicked
     * @return - note from particular match
     */
    public String findNote(String position) {

        return matches.get(Integer.parseInt(position)).getNote();
    }
}
