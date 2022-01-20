package repository;

import android.content.Context;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import module.Note;

public class UseCaseRepository {

            NoteDao noteDao;

            public UseCaseRepository(Context context){
                MainDatabase mainDatabase = MainDatabase.getInstance(context);
                noteDao = mainDatabase.noteDao();
            }

            public List<Note> getAll(){
                return noteDao.getAll();
            }

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
