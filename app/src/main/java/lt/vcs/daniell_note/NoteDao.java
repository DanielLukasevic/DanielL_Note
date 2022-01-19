package lt.vcs.daniell_note;


import static lt.vcs.daniell_note.Constants.DATABASE_TABLE_NOTES;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NoteDao {
    @Query("SELECT * FROM " + DATABASE_TABLE_NOTES)
    List<Note> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNotes(List<Note> notes);



}
