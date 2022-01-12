package lt.vcs.daniell_note;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "app test";
    private List<Note> notes;
    private ArrayAdapter<Note> arrayAdapter;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
         fab = findViewById(R.id.fab);

        UseCaseRepository useCaseRepository = new UseCaseRepository();

        setUpListView(useCaseRepository, listView);

        onClickItem(listView);

        onLongClickItem(listView);

        setUpFab();
    }



    @NonNull
    private void setUpListView(UseCaseRepository useCaseRepository, ListView listView) {
        notes = useCaseRepository.generateNoteList(15);

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notes);
        listView.setAdapter(arrayAdapter);
    }

    private void onClickItem(ListView listView){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(TAG, "onItemClick: " + notes.get(position));

            }
        });
    }

    private void onLongClickItem(ListView listView) {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                notes.remove(position);
//                arrayAdapter.notifyDataSetChanged();
                showAlertDialog(position);
                return true;
            }
        });
    }

    private void setUpFab() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar
                        .make(v, R.string.some_text, Snackbar.LENGTH_SHORT)
                        .show();
            }
        });
    }

    private void showAlertDialog(int position){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you would like to remove?");
        builder.setPositiveButton("Yes", null);
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
                    public void onClick(DialogInterface dialog, int which){
                notes.remove(position);
                arrayAdapter.notifyDataSetChanged();
            }
        });
        builder.show();
    }
}