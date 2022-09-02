package com.example.todopractice_7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
private FloatingActionButton actionButton;
private ArrayList<Note>notes = new ArrayList<Note>();
private RecyclerView recyclerViewNotes;
private NotesAdapter notesAdapter;
private DataBase dataBase = DataBase.getInstance();

    @Override
    protected void onResume() {
        super.onResume();
        showNotes();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        notesAdapter = new NotesAdapter();
        notesAdapter.setOnNoteClickListener(new NotesAdapter.OnNoteClickListener() {//6
            @Override
            public void onNoteClick(Note note) {//!!
            dataBase.removeNote(note.getId());//7
            showNotes();//8
            }
        });

        recyclerViewNotes.setAdapter(notesAdapter);

        showNotes();
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent intent =   AddNoteActivity.newIntent(MainActivity.this);
              startActivity(intent);
            }
        });



    }
    public void initViews(){
        actionButton = findViewById(R.id.floatingButton);
        recyclerViewNotes = findViewById(R.id.recyclerViewNotes);
    }
    public void showNotes(){
        notesAdapter.setNotes(dataBase.getNotes());

    }


}