package lt.vcs.daniell_note;



import static lt.vcs.daniell_note.Constants.APP_TEST;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class NoteDetails extends AppCompatActivity {
    private static final String APP_TEST  = "app test";


    @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_details);

        Intent intent = getIntent();
        String messageOne = intent.getStringExtra("lt.vcs.daniell.main_activity_one");
        String messageTwo = intent.getStringExtra("lt.vcs.daniell.main_activity_two");
        Log.i(APP_TEST , "onCreate: " + messageOne);
        Log.i(APP_TEST , "onCreate: " + messageTwo);
    }
}