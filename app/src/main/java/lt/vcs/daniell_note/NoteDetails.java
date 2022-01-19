package lt.vcs.daniell_note;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class NoteDetails extends AppCompatActivity {
    private static final String TAG = "app test";


    @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_details);

        Intent intent = getIntent();
        String messageOne = intent.getStringExtra("lt.vcs.daniell.main_activity_one");
        String messageTwo = intent.getStringExtra("lt.vcs.daniell.main_activity_two");
        Log.i(TAG, "onCreate: " + messageOne);
        Log.i(TAG, "onCreate: " + messageTwo);
    }
}