package repository;

import static lt.vcs.daniell_note.Constants.DATABASE_NAME;
import static lt.vcs.daniell_note.Constants.DATABASE_VERSION;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
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

    private static MainDatabase instance;

    public static MainDatabase getInstance(Context context){
        if(instance == null){
            instance =  Room.databaseBuilder(
                    context,
                    MainDatabase.class,
                    DATABASE_NAME
            )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public abstract NoteDao noteDao();
}
