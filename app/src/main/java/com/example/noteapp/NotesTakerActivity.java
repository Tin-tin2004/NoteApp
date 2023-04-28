package com.example.noteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.noteapp.Models.Notes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NotesTakerActivity extends AppCompatActivity {
    EditText edittext_title, edittext_notes;
    ImageView save;
    Notes notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_taker);

        save = findViewById(R.id.save);
        edittext_title = findViewById(R.id.edittext_title);
        edittext_notes = findViewById(R.id.edittext_notes);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = edittext_title.getText().toString();
                String desc = edittext_notes.getText().toString();

                if(desc.isEmpty()){
                    Toast.makeText(NotesTakerActivity.this, "add notes.", Toast.LENGTH_SHORT).show();
                    return;
                }
                SimpleDateFormat formatter = new SimpleDateFormat("EEE, d MMM yyyy HH:mm.a");
                Date date = new Date();

                notes = new Notes();

                notes.setTitle(title);
                notes.setNotes(desc);
                notes.setDate(formatter.format(date));

                Intent intent = new Intent();
                intent.putExtra("note", notes);
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
    }
}