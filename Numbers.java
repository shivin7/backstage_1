package com.example.shivin.backstage1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;

public class Numbers extends AppCompatActivity
{
    public final static String sectag = "com.example.shivin.backstage1.sec";
    public final static String firtag = "com.example.shivin.backstage1.fir";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
    }

    public void sendNumbers(View view)
    {
        Intent in = new Intent(this, Names.class);
        EditText secondie = (EditText)findViewById(R.id.editText);
        EditText firstie = (EditText)findViewById(R.id.editText2);
        String sec = secondie.getText().toString();
        String fir = firstie.getText().toString();
        in.putExtra(sectag, sec);
        in.putExtra(firtag, fir);
        startActivity(in);
    }
}
