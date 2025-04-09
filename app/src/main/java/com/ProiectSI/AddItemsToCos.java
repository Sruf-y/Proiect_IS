package com.ProiectSI;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.navigation.ActivityNavigator;

import DataClasses.GlobalVars;
import DataClasses.Meniu_Item;
import Functii_Utils.Functii;
import Start_Activity.File_Salvate;


public class AddItemsToCos extends AppCompatActivity {


    //variabile aici
    Meniu_Item item;
    Integer numar=0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Leaga clasa MainActivity de design-ul activity_main
        setContentView(R.layout.activity_additemstocos);


        // leaga obiectele din design de date in cod
        //        data                     obiect din design
        TextView text_box = findViewById(R.id.firsttextview);

        ImageView plusbuton = findViewById(R.id.plusButton);

        ImageView buton_minus = findViewById(R.id.minusbuton);

        Button close_button = findViewById(R.id.button3);
        close_button.setText("<-Back");
        close_button.setGravity(Gravity.CENTER);

        TextView infotextview = findViewById(R.id.textView7);

        item = getIntent().getParcelableExtra("item", Meniu_Item.class);
        numar = getIntent().getParcelableExtra("itemNr", Integer.class);
        if(item==null && numar==null){
            finish();
            return;
        }

        if(GlobalVars.INSTANCE.getComanda_in_cos().getList().contains(item)){
            numar=GlobalVars.INSTANCE.getComanda_in_cos().getListNumberOfs().get(GlobalVars.INSTANCE.getComanda_in_cos().getList().indexOf(item));
        }
        else{

        }


        text_box.setText(numar.toString());

        if(numar<=0){
            buton_minus.setEnabled(false);
            collorchangeforButton(buton_minus, this,R.color.inactive);
            numar=0;
            text_box.setText(numar.toString());
        }
        else if(numar>=10){
            plusbuton.setEnabled(false);
            collorchangeforButton(plusbuton,this,R.color.inactive);
            numar=10;
            text_box.setText(numar.toString());
        }


        infotextview.setText(item.getDescription()+"\n\n\n\n"+item.getNutritionDescription());




        Runnable checkButtons = ()->{
            if(numar<=0){
                buton_minus.setEnabled(false);
                plusbuton.setEnabled(true);
                collorchangeforButton(buton_minus,this,R.color.inactive);
                collorchangeforButton(plusbuton,this,R.color.activated);
                numar=0;
                text_box.setText(numar.toString() + " (min)");
            }
            else if(numar>=10){
                buton_minus.setEnabled(true);
                plusbuton.setEnabled(false);
                collorchangeforButton(buton_minus,this,R.color.activated);
                collorchangeforButton(plusbuton,this,R.color.inactive);
                numar=10;
                text_box.setText(numar.toString()+" (max)");
            }
            else{
                buton_minus.setEnabled(true);
                plusbuton.setEnabled(true);
                collorchangeforButton(buton_minus,this,R.color.activated);
                collorchangeforButton(plusbuton,this,R.color.activated);
                text_box.setText(numar.toString());
            }
        };




        plusbuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // ce sa se intample cand apas butonul
                if(numar<10){
                    numar+=1;

                }

                checkButtons.run();

                // se pot seta unele proprietati prin program ca textul sau marimea lui. Chiar si culoarea.


                Log.d("TagToSearchForInLogs", "Plus");
            }
        });


        buton_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // ce sa se intample cand apas butonul
                if (numar >= 1) {
                    numar -= 1;
                }
                checkButtons.run();



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
            private final Handler handler = new Handler(Looper.getMainLooper());



            @Override
            public boolean onLongClick(View view) {

                Runnable runnable = new Runnable() {// clasa care ruleaza ceva pe loop
                    int increment = 1;

                    @Override
                    public void run() {
                        //verific daca butonul inca este apasat
                        if (buton_minus.isPressed() && buton_minus.isEnabled()) {
                            if (numar >= 1) {
                                numar -= 1;
                            }
                            checkButtons.run();


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
            private final Handler handler = new Handler(Looper.getMainLooper());


            @Override
            public boolean onLongClick(View view) {

                Runnable runnable = new Runnable() {// clasa care ruleaza ceva pe loop
                    int increment = 1;
                    @Override

                    public void run() {
                        //verific daca butonul inca este apasat
                        if (plusbuton.isPressed() && plusbuton.isEnabled()) {
                            if(numar<10){
                                numar+=1;

                            }

                            checkButtons.run();

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

    private static void collorchangeforButton(View but, Context context, int colorId){
        but.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(context,colorId)));
        but.setBackgroundTintMode(PorterDuff.Mode.ADD);
    }


    @Override
    protected void onPause() {
        super.onPause();


        if(GlobalVars.INSTANCE.getComanda_in_cos().getList().contains(item)){
            int pos = GlobalVars.INSTANCE.getComanda_in_cos().getList().indexOf(item);

            if(numar<=0){

                GlobalVars.INSTANCE.getComanda_in_cos().removeItem(item);
            }else{
                GlobalVars.INSTANCE.getComanda_in_cos().setAt(pos,item,numar);
            }
        }
        else{ // daca nu se afla in comanda curenta
            if(numar>0){
                GlobalVars.INSTANCE.getComanda_in_cos().addItem(item,numar);
            }
        }
    }

    @Override
    protected void onResume(){
        super.onResume();

        // cand vad din nou activitatea
    }
}




