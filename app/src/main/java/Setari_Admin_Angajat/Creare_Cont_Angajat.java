package Setari_Admin_Angajat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.ProiectSI.R;

import java.util.ArrayList;

import DataClasses.Angajat;
import DataClasses.GlobalVars;
import Functii_Utils.Functii;
import Start_Activity.File_Salvate;


public class Creare_Cont_Angajat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creare_cont_angajat);
        //aici cod

        EditText etUsername = findViewById(R.id.et_username);
        EditText etPassword = findViewById(R.id.et_password);
        Button btnAdauga = findViewById(R.id.btn_adauga);

        btnAdauga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                Angajat nouAngajat = new Angajat(username, password);
                adaugaAngajat(nouAngajat);
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