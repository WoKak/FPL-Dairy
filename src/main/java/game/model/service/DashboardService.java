package game.model.service;

import game.model.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michał on 2017-08-01.
 * Service for DashboardAjaxController
 */

@Service
public class DashboardService {

    private DataSource dataSource;

    @Autowired
    public DashboardService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * Finds list of matches by criteria.
     * @param criteria - data provided by user in dashboard form
     * @return - list of matching matches
     */
    public List<Match> findMatchesByCriteria(String criteria) throws SQLException{

        List<Match> toReturn = new ArrayList<>();

        Connection connection = dataSource.getConnection();

        String query = "SELECT * FROM matches WHERE day_number=?";
        PreparedStatement pstat = connection.prepareStatement(query);
        pstat.setInt(1, Integer.parseInt(criteria));
        ResultSet result = pstat.executeQuery();

        while (result.next()) {

            Blob tmpBlob = result.getBlob(6);
            String tmpString = new String(tmpBlob.getBytes(1L, (int) tmpBlob.length()));

            toReturn.add(new Match(
                    result.getInt(1),
                    result.getString(2),
                    result.getString(3),
                    result.getInt(4),
                    result.getInt(5),
                    tmpString
            ));
        }

        return toReturn;
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
