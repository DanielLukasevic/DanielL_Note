package repository;

import static lt.vcs.daniell_note.Constants.DATABASE_VERSION;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import module.Note;

@Database(
        entities = {Note.class},
        version = DATABASE_VERSION,
        exportSchema = false
)
@TypeConverters({Converter.class})
public abstract class MainDatabase extends RoomDatabase {
    public abstract NoteDao noteDao();
}
