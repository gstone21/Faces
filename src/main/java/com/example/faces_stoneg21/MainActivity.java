package com.example.faces_stoneg21;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);

        Face face_id = (Face) findViewById(R.id.face);
        FaceController face_con = new FaceController(face_id);


        Spinner styleSpinner = findViewById(R.id.hairSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.hairStyles, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        styleSpinner.setAdapter(adapter);
        styleSpinner.setOnItemSelectedListener(face_con);

        RadioGroup colorSelect = findViewById(R.id.radioHES);
        colorSelect.setOnCheckedChangeListener(face_con);


        SeekBar redBar = findViewById(R.id.redSeekBar);
        redBar.setOnSeekBarChangeListener(face_con);
        redBar.setProgress(face_id.red);

        SeekBar greenBar = findViewById(R.id.greenSeekBar);
        greenBar.setOnSeekBarChangeListener(face_con);
        greenBar.setProgress(face_id.green);

        SeekBar blueBar = findViewById(R.id.blueSeekBar);
        blueBar.setOnSeekBarChangeListener(face_con);
        blueBar.setProgress(face_id.blue);

        Button randomButton = findViewById(R.id.randomFaceButton);
        randomButton.setOnClickListener(face_con);


    }


}
