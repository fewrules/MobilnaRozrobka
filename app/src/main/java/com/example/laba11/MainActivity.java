package com.example.laba11;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity implements ActivityButton.ListenerA{

    private ActivityButton FragmentA;
    private ActivityResult FragmentB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentA = ActivityButton.newInstance();
        FragmentB = ActivityResult.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_a, FragmentA)
                .replace(R.id.container_b, FragmentB)
                .commit();

    }

    @Override
    public void onInputASent() {
        RadioGroup RadioA = findViewById(R.id.radioGroup);
        RadioButton checked = findViewById(RadioA.getCheckedRadioButtonId());
        Spinner spined = (Spinner) findViewById(R.id.spinner1);
        CharSequence input1 = spined.getSelectedItem().toString();
        CharSequence input2 = checked.getText();
        TextView model = findViewById(R.id.textView2);
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                    openFileOutput("file.txt", MODE_PRIVATE)));
            bw.write("Model: " + input1 + " " + "Vendor: "+ input2);
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.setText("Model: " +input1);
        TextView vendor = findViewById(R.id.textView1);
        vendor.setText("Vendor: "+input2);
    }

    @Override
    public void onInputBSent(){
        Intent myIntent = new Intent(this, Main2Activity.class);
        startActivity(myIntent);
    }
}
