package Setari_Admin_Angajat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.ProiectSI.R;

import java.util.ArrayList;
import java.util.Objects;

import DataClasses.Angajat;
import DataClasses.GlobalVars;
import Functii_Utils.Functii;
import Start_Activity.File_Salvate;


public class Creare_Cont_Angajat extends AppCompatActivity {

    Angajat ang;
    String angajatpreviousname="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creare_cont_angajat);
        //aici cod

        ang = getIntent().getParcelableExtra("ang",Angajat.class);


        EditText etUsername = findViewById(R.id.et_username);
        EditText etPassword = findViewById(R.id.et_password);


        if(ang!=null){
            etUsername.setText(ang.username);
            angajatpreviousname=ang.username;
            etPassword.setText(ang.password);
        }

        Button btnAdauga = findViewById(R.id.btn_adauga);

        btnAdauga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                if(ang!=null){
                    GlobalVars.INSTANCE.getLista_Angajati().stream().filter(p-> Objects.equals(p.username, angajatpreviousname)).findFirst().get().password=password;
                    GlobalVars.INSTANCE.getLista_Angajati().stream().filter(p-> Objects.equals(p.username, angajatpreviousname)).findFirst().get().username=username;

                    Functii.Companion.SaveAsJson(Creare_Cont_Angajat.this,
                            File_Salvate.Lista_Angajati.toString(),
                            GlobalVars.INSTANCE.getLista_Angajati()
                    );

                    finish();
                }
                else{
                    Angajat nouAngajat = new Angajat(username, password);
                    adaugaAngajat(nouAngajat);
                    finish();
                }

            }
        });
    }
    private void adaugaAngajat(Angajat angajat) {

        GlobalVars.INSTANCE.getLista_Angajati().add(angajat);

        Functii.Companion.SaveAsJson(this,
                File_Salvate.Lista_Angajati.toString(),
                GlobalVars.INSTANCE.getLista_Angajati()
        );
    }

    @Override
    protected void onResume(){
        super.onResume();



        ArrayList<Angajat> listaAngajati = Functii.Companion.LoadFromJson(this, "Lista_Angajati", GlobalVars.INSTANCE.getLista_Angajati());
        GlobalVars.INSTANCE.setLista_Angajati(listaAngajati);




    }
}