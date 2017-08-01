package game.domain;

import com.fasterxml.jackson.annotation.JsonView;
import game.domain.Match;
import game.web.Views;

import java.util.List;

/**
 * Created by Michał on 2017-08-01.
 */
public class AjaxResponseBody {

    @JsonView(Views.Public.class)
    List<Match> matches;

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }
}
