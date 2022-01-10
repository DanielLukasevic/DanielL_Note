package lt.vcs.daniell_note;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UseCaseRepository {
    @NonNull
            public List<Note> generateNoteList(int count) {
        List<Note> notes = new ArrayList<>();

        Random random = new Random();
        Note note;

        int id = 1;
        while (id <= count) {
            note = new Note(id, "Name" + id, "Content" + 1 + " - " + random.nextInt(1000000));
            notes.add(note);
            id++;
        }
        return notes;
    }
}
