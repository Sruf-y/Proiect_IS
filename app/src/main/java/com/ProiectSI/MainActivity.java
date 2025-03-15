package com.ProiectSI;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


    //variabile aici
    Float numar=14F;



    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Leaga clasa MainActivity de design-ul activity_main
        setContentView(R.layout.activity_main);


        // leaga obiectele din design de date in cod
        //        data                     obiect din design
        TextView text_box = findViewById(R.id.firsttextview);
        text_box.setText("Size "+numar);

        ImageView plusbuton = findViewById(R.id.plusButton);

        ImageView buton_minus = findViewById(R.id.minusbuton);

        Button close_button = findViewById(R.id.button3);

        Button another_activity = findViewById(R.id.button);

        // set click action for button/ orice alt "View" (view = obiect grafic)

        another_activity.setOnClickListener(new View.OnClickListener() {
            // codul aici este comentat pt ca am sters layout-ul la care duce
            @Override
            public void onClick(View view) {
                //Intent activitystarter = new Intent(MainActivity.this, SecondActivity.class);
                //startActivity(activitystarter);
            }
        });




        plusbuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // ce sa se intample cand apas butonul
                if(numar<50F)
                    numar+=1F;

                // se pot seta unele proprietati prin program ca textul sau marimea lui. Chiar si culoarea.
                text_box.setTextSize(numar);

                text_box.setText("Size "+numar);
                Log.d("TagToSearchForInLogs", "Plus");
            }
        });


        buton_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // ce sa se intample cand apas butonul
                if(numar>5F)
                    numar-=1F;


                text_box.setTextSize(numar);

                text_box.setText("Size "+numar);
                Log.d("TagToSearchForInLogs", "Minus");
            }
        });

        close_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });


        // mai complicat, longClick se poate folosi pentru alte functionalitati sau aceleasi. Depinde de voi.
        buton_minus.setOnLongClickListener(new View.OnLongClickListener() {
            private Handler handler = new Handler(Looper.getMainLooper());



            @Override
            public boolean onLongClick(View view) {

                Runnable runnable = new Runnable() {// clasa care ruleaza ceva pe loop
                    int increment = 1;

                    @Override
                    public void run() {
                        //verific daca butonul inca este apasat
                        if (buton_minus.isPressed()) {
                            if (numar > 5F) {
                                numar -= 1F;

                                text_box.setTextSize(numar);
                                text_box.setText("Size " + numar);
                            }

                            if(increment<=5)
                                increment++;

                            handler.postDelayed(this,500/increment); // ruleaza codul superior(functia run) dupa 0.5 secunda
                        }
                    }
                };

                // start runnable
                handler.post(runnable);

                // pus de intelisense
                return true;
            }


        });


        plusbuton.setOnLongClickListener(new View.OnLongClickListener() {
            private Handler handler = new Handler(Looper.getMainLooper());


            @Override
            public boolean onLongClick(View view) {

                Runnable runnable = new Runnable() {// clasa care ruleaza ceva pe loop
                    int increment = 1;
                    @Override

                    public void run() {
                        //verific daca butonul inca este apasat
                        if (plusbuton.isPressed()) {
                            if (numar < 50F) {
                                numar += 1F;

                                text_box.setTextSize(numar);
                                text_box.setText("Size " + numar);
                            }

                            if(increment<=5)
                                increment++;

                            handler.postDelayed(this, 500/increment); // ruleaza codul superior(functia run) dupa 0.5 secunda
                        }
                    }
                };

                // start runnable
                handler.post(runnable);

                // return pus de intelisense
                return true;
            }
        });








    }

    @Override
    protected void onPause(){
        super.onPause();// constructor de baza

        // cand nu mai vad activitatea
    }

    @Override
    protected void onResume(){
        super.onResume();

        // cand vad din nou activitatea
    }
}




