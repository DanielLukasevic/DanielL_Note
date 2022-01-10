package lt.vcs.daniell_note;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "app test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List<Note> notes = new ArrayList<>();

        Random random = new Random();
        Note note;

        int id = 1;
        while(id <= 10){
            note = new Note(id, "Name" + id, "Content" + 1 + " - " + random.nextInt(1000000));
            notes.add(note);
            id++;
        }

//        notes.add(new Note(1,"Name1", "Content1"));
//        notes.add(new Note(2,"Name2", "Content2"));
//        notes.add(new Note(3,"Name3", "Content3"));
//        notes.add(new Note(4,"Name4", "Content4"));
//        notes.add(new Note(5,"Name5", "Content5"));

        ArrayAdapter<Note> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notes);

        ListView listView = findViewById(R.id.listView);

        listView.setAdapter(arrayAdapter);

        AdapterView.OnItemClickListener listner = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Log.i(TAG, "onItemClick: " + position);
            }
        };
        listView.setOnItemClickListener(listner);
    }
}