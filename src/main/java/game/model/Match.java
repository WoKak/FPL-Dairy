package game.model;

import com.fasterxml.jackson.annotation.JsonView;
import game.web.Views;

/**
 * Created by Michał on 2017-07-29.
 */
public class Match {

    @JsonView(Views.Public.class)
    private int dayNumber;

    @JsonView(Views.Public.class)
    private String homeTeam;

    @JsonView(Views.Public.class)
    private String awayTeam;

    @JsonView(Views.Public.class)
    private int homeGoals;

    @JsonView(Views.Public.class)
    private int awayGoals;

    @JsonView(Views.Public.class)
    private String note;

    public Match() {
    }

    public Match(int dayNumber, String homeTeam, String awayTeam, int homeGoals, int awayGoals, String note) {
        this.dayNumber = dayNumber;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
        this.note = note;

    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(int homeGoals) {
        this.homeGoals = homeGoals;
    }

    public int getAwayGoals() {
        return awayGoals;
    }

    public void setAwayGoals(int awayGoals) {
        this.awayGoals = awayGoals;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Match{" +
                "dayNumber=" + dayNumber +
                ", homeTeam='" + homeTeam + '\'' +
                ", awayTeam='" + awayTeam + '\'' +
                ", homeGoals=" + homeGoals +
                ", awayGoals=" + awayGoals +
                ", note='" + note + '\'' +
                '}';
    }
}
