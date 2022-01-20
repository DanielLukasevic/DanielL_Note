package lt.vcs.daniell_note;



import static lt.vcs.daniell_note.Constants.APP_TEST;
import static lt.vcs.daniell_note.Constants.DATABASE_NAME;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;


import java.util.List;

import module.Note;
import repository.MainDatabase;
import repository.NoteDao;
import repository.UseCaseRepository;

public class MainActivity extends AppCompatActivity {

    private List<Note> notes;
    private ArrayAdapter<Note> arrayAdapter;
    private FloatingActionButton fab;

    @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
         fab = findViewById(R.id.fab);

         UseCaseRepository useCaseRepository = new UseCaseRepository(getApplicationContext());
            notes = useCaseRepository.getAll();

       //UseCaseRepository useCaseRepository = new UseCaseRepository();


//        NoteDao noteDao = database.noteDao();
//
//        notes = noteDao.getAll();
//        Log.i(APP_TEST,"onCreate: " + noteDao.getAll());
//        Log.i(APP_TEST, "onCreate: " + noteDao.getItem(5));



        setUpListView(listView);

        onClickItem(listView);

        onLongClickItem(listView);

        setUpFab();
    }



    @NonNull
    private void setUpListView( ListView listView) {
//        notes = useCaseRepository.generateNoteList(15);

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notes);
        listView.setAdapter(arrayAdapter);
    }

    private void onClickItem(ListView listView){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Log.i(TAG, "onItemClick: " + notes.get(position));

                Intent intent = new Intent(MainActivity.this, NoteDetails.class);
                intent.putExtra("lt.vcs.daniell.main_activity_one", notes.get(position).getName());
                intent.putExtra("lt.vcs.daniell.main_activity_two", notes.get(position).toString());
                startActivity(intent);
            }
        });
    }

    private void onLongClickItem(ListView listView) {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
               notes.remove(position);
               arrayAdapter.notifyDataSetChanged();
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