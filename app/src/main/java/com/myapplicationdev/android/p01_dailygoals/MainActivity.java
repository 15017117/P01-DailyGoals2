package com.myapplicationdev.android.p01_dailygoals;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg1;
    RadioGroup rg2;
    RadioGroup rg3;
    EditText etRT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSubmit = (Button)findViewById(R.id.btnSubmit);

        rg1 = (RadioGroup)findViewById(R.id.rg1);
        rg2 = (RadioGroup)findViewById(R.id.rg2);
        rg3 = (RadioGroup)findViewById(R.id.rg3);
        etRT  =(EditText)findViewById(R.id.etRT);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View args0) {

                int selectedButtonId = rg1.getCheckedRadioButtonId();
                RadioButton rb1 = (RadioButton)findViewById(selectedButtonId);
                int selectedButtonId2 = rg2.getCheckedRadioButtonId();
                RadioButton rb2 = (RadioButton)findViewById(selectedButtonId2);
                int selectedButtonId3 = rg3.getCheckedRadioButtonId();
                RadioButton rb3 = (RadioButton)findViewById(selectedButtonId3);

                EditText etRT = (EditText)findViewById(R.id.etRT);

                String[] info = {rb1.getText().toString(),rb2.getText().toString(),rb3.getText().toString(),etRT.getText().toString()};
                Intent i = new Intent(MainActivity.this, result.class);
                i.putExtra("info", info);
                startActivity(i);


                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                SharedPreferences.Editor prefEdit = prefs.edit();
                prefEdit.putInt("rb1",rg1.getCheckedRadioButtonId());
                prefEdit.commit();

                SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                SharedPreferences.Editor prefEdit2 = prefs1.edit();
                prefEdit2.putInt("rb2",rg2.getCheckedRadioButtonId());
                prefEdit2.commit();

                SharedPreferences prefs2 = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                SharedPreferences.Editor prefEdit3 = prefs2.edit();
                prefEdit3.putInt("rb3",rg3.getCheckedRadioButtonId());
                prefEdit3.commit();

                SharedPreferences prefs3 = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                SharedPreferences.Editor prefEdit4 = prefs3.edit();
                prefEdit4.putString("etRT",etRT.getText().toString());
                prefEdit4.commit();
                // Start the new activity


            }
        });


    }
    protected void onResume(){
        super.onResume();
        SharedPreferences prefs =PreferenceManager.getDefaultSharedPreferences(this);
        int rg11 = prefs.getInt("rb1",0);
        SharedPreferences prefs2 =PreferenceManager.getDefaultSharedPreferences(this);

        int rg22 = prefs2.getInt("rb2",0);
        SharedPreferences prefs3 =PreferenceManager.getDefaultSharedPreferences(this);
        int rg33 = prefs3.getInt("rb3",0);

        SharedPreferences prefs4 =PreferenceManager.getDefaultSharedPreferences(this);
        String etRT1 = prefs4.getString("etRT","");

        rg1.check(rg11);
        rg2.check(rg22);
        rg3.check(rg33);
        etRT.setText(etRT1);


    }

}
