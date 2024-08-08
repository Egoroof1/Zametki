package com.diego.zametki;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.diego.zametki.Models.Notes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NotesTakerActivity extends AppCompatActivity {

    EditText editText_Title, editText_notes;
    ImageView imageView_save;
    Notes notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_notes_taker);

        editText_Title = findViewById(R.id.editText_Title);
        editText_notes = findViewById(R.id.editText_notes);

        imageView_save = findViewById(R.id.imageView_save);
        imageView_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = editText_Title.getText().toString();
                String description = editText_notes.getText().toString();
                if (description.isEmpty()){
                    Toast.makeText(NotesTakerActivity.this, "Please, enter description", Toast.LENGTH_SHORT).show();
                    return;
                }
                SimpleDateFormat formater = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");
                Date date = new Date();

                notes = new Notes();
                notes.setTitle(title);
                notes.setNotes(description);
                notes.setData(formater.format(date));

                Intent intent = new Intent();
                intent.putExtra("notes", notes);
                setResult(Activity.RESULT_OK, intent);

                finish();
            }
        });
    }
}