package game.model;

import com.fasterxml.jackson.annotation.JsonView;
import game.web.Views;

/**
 * Created by Michał on 2017-08-02.
 * Simple class for mapping Java object to JSON
 */
public class FoundNoteResponseBody {

    @JsonView(Views.Public.class)
    private String note;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
