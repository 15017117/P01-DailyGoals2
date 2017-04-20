package com.myapplicationdev.android.p01_dailygoals;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent i = getIntent();
        String[] info = i.getStringArrayExtra("info");

        TextView tv = (TextView)findViewById(R.id.viewResult);
        tv.setText("Read up on materials before class : "+info[0]+"\nArrive in time so as not to miss important part of the lesson: "+info[1]+
                "\nAttempt the problem myself: "+info[2]+"\nReflection: "+info[3]);


    }

}
