package lt.vcs.daniell_note;



import androidx.annotation.NonNull;
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

        ListView listView = findViewById(R.id.listView);

        UseCaseRepository useCaseRepository = new UseCaseRepository();

        setUpListView(useCaseRepository, listView);

        AdapterView.OnItemClickListener listner = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Log.i(TAG, "onItemClick: " + position);
            }
        };
        listView.setOnItemClickListener(listner);
    }
    @NonNull
    private void setUpListView(UseCaseRepository useCaseRepository, ListView listView) {
        List<Note> notes = useCaseRepository.generateNoteList(15);

        ArrayAdapter<Note> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notes);
        listView.setAdapter(arrayAdapter);
    }
}