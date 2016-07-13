package com.example.shivin.backstage1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.Image;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;

public class Disp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disp);

        Intent in = getIntent();
        String[] firArray = in.getStringArrayExtra("FA");
        String[] secArray = in.getStringArrayExtra("SA");

        RelativeLayout buttonLayout = (RelativeLayout) findViewById(R.id.buttonLayout);
        LinearLayout mainLayout = (LinearLayout) findViewById(R.id.mainLayout);
        LinearLayout namesLayout = (LinearLayout) findViewById(R.id.namesLayout);
        LinearLayout secondieLayout = (LinearLayout) findViewById(R.id.secondieLayout);
        LinearLayout firstieLayout = (LinearLayout) findViewById(R.id.firstieLayout);

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
        firstieHeadingDetails.setMargins(0,20,0,5);
        secondieHeadingDetails.setMargins(0,20,0,5);
        firstieHeading.setTextSize(30);
        secondieHeading.setTextSize(30);
        firstieHeading.setTextColor(Color.WHITE);
        secondieHeading.setTextColor(Color.WHITE);
        firstieHeading.setTypeface(null, Typeface.BOLD);
        secondieHeading.setTypeface(null, Typeface.BOLD);

        firstieLayout.addView(firstieHeading, firstieHeadingDetails);
        secondieLayout.addView(secondieHeading, secondieHeadingDetails);

        for (int i = 0; i < firArray.length; i++) {
            TextView tv = new TextView(this);
            tv.setText(firArray[i]);
            LinearLayout.LayoutParams tvDetails = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            tvDetails.gravity = Gravity.CENTER_HORIZONTAL;
            tvDetails.setMargins(0, 15, 0, 0);
            tv.setTextSize(25);
            tv.setTextColor(Color.WHITE);

            firstieLayout.addView(tv, tvDetails);
        }

        for (int i = 0; i < secArray.length; i++) {
            TextView tv = new TextView(this);
            tv.setText(secArray[i]);
            LinearLayout.LayoutParams tvDetails = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            tvDetails.gravity = Gravity.CENTER_HORIZONTAL;
            tvDetails.setMargins(0, 15, 0, 0);
            tv.setTextSize(25);
            tv.setTextColor(Color.WHITE);

            secondieLayout.addView(tv, tvDetails);
        }

    }


    public void saveImage(View view)
    {
        LinearLayout content = (LinearLayout)findViewById(R.id.namesLayout);
        content.setDrawingCacheEnabled(true);
        Bitmap bitmap = content.getDrawingCache();

        File myDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/Allotments/");

        String fname = "Image.jpg";
        File file = new File (myDir.getAbsolutePath(), fname);
        if (file.exists ()) file.delete ();
        try {
            FileOutputStream out = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.flush();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
