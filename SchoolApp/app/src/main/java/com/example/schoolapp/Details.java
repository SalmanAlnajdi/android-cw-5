package com.example.schoolapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Bundle b = getIntent().getExtras();
        Section s = (Section) b.getSerializable("StudentD");

        ImageView img = findViewById(R.id.img2);
        TextView name = findViewById(R.id.name2);
        TextView edu = findViewById(R.id.edu2);


        name.setText(s.getName());
        edu.setText(s.getEduLevel());
        img.setImageResource(s.getImg());
    }
}