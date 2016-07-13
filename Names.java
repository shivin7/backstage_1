package com.example.shivin.backstage1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Names extends AppCompatActivity
{
    int firstNumber,secondNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_names);

        Intent in = getIntent();
        String firstieNumber = in.getStringExtra(Numbers.firtag);
        String secondieNumber = in.getStringExtra(Numbers.sectag);

        RelativeLayout buttonLayout = (RelativeLayout)findViewById(R.id.buttonLayout);
        LinearLayout mainLayout = (LinearLayout)findViewById(R.id.mainLayout);
        LinearLayout namesLayout = (LinearLayout)findViewById(R.id.namesLayout);
        LinearLayout secondieLayout = (LinearLayout)findViewById(R.id.secondieLayout);
        LinearLayout firstieLayout = (LinearLayout)findViewById(R.id.firstieLayout);

        TextView firstieHeading = new TextView(this);
        firstieHeading.setText("FIRSTIES");
        TextView secondieHeading = new TextView(this);
        secondieHeading.setText("SECONDIES");

        LinearLayout.LayoutParams firstieHeadingDetails = new LinearLayout.LayoutParams
                (
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
        LinearLayout.LayoutParams secondieHeadingDetails = new LinearLayout.LayoutParams
                (
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        firstieHeadingDetails.gravity = Gravity.CENTER_HORIZONTAL;
        secondieHeadingDetails.gravity = Gravity.CENTER_HORIZONTAL;
        firstieHeadingDetails.setMargins(0,15,0,0);
        secondieHeadingDetails.setMargins(0, 15, 0, 0);
        firstieHeading.setTextSize(22);
        secondieHeading.setTextSize(22);

        firstieLayout.addView(firstieHeading, firstieHeadingDetails);
        secondieLayout.addView(secondieHeading,secondieHeadingDetails);

        firstNumber = Integer.parseInt(firstieNumber);
        secondNumber = Integer.parseInt(secondieNumber);

        for(int i=0;i<firstNumber;i++)
        {
            EditText et = new EditText(this);
            LinearLayout.LayoutParams etDetails = new LinearLayout.LayoutParams(
                    250, LinearLayout.LayoutParams.WRAP_CONTENT
            );
            etDetails.gravity = Gravity.CENTER_HORIZONTAL;
            etDetails.setMargins(0,10,0,0);

            et.setId(i);
            firstieLayout.addView(et, etDetails);
        }
        for(int i=0;i<secondNumber;i++)
        {
            EditText et = new EditText(this);
            LinearLayout.LayoutParams etDetails = new LinearLayout.LayoutParams(
                    250,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            etDetails.gravity = Gravity.CENTER_HORIZONTAL;
            etDetails.setMargins(0,10,0,0);

            et.setId(i+firstNumber);
            secondieLayout.addView(et,etDetails);
        }

    }

    public void sendNames (View view)
    {
        String firArray[] = new String[firstNumber];
        String secArray[] = new String[secondNumber];

        for(int i=0; i<firstNumber; i++)
        {
            EditText et=(EditText)findViewById(i);
            firArray[i]=et.getText().toString();
        }
        for(int i=0; i<secondNumber; i++)
        {
            EditText et = (EditText)findViewById(i+firstNumber);
            secArray[i] = et.getText().toString();
        }

        Intent in = new Intent(this, Disp.class);
        in.putExtra("FA",firArray);
        in.putExtra("SA",secArray);
        startActivity(in);
    }
}
