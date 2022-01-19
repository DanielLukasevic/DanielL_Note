package lt.vcs.daniell_note;

import static lt.vcs.daniell_note.Constants.DATABASE_VERSION;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(
        entities = {Note.class},
        version = DATABASE_VERSION,
        exportSchema = false
)

public abstract class MainDatabase extends RoomDatabase {
    public abstract NoteDao noteDao();
}
