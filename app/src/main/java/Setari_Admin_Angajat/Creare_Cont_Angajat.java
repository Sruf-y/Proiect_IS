package Setari_Admin_Angajat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ProiectSI.R;

import java.util.ArrayList;
import java.util.List;

import DataClasses.Angajat;
import DataClasses.GlobalVars;
import Functii_Utils.Functii;




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
        List<Angajat> listaAngajati = GlobalVars.INSTANCE.getLista_Angajati();

        if (listaAngajati == null) {
            listaAngajati = new ArrayList<>();
        }

        listaAngajati.add(angajat);

        GlobalVars.INSTANCE.setLista_Angajati((ArrayList<Angajat>) listaAngajati);

        Functii.Companion.SaveAsJson(this, "Lista_Angajati", listaAngajati);
    }

    @Override
    protected void onResume(){
        super.onResume();
        List<Angajat> listaAngajati = Functii.Companion.LoadFromJson(this, "Lista_Angajati", new ArrayList<>(), ArrayList.class);
        GlobalVars.INSTANCE.setLista_Angajati((ArrayList<Angajat>) listaAngajati);

    }
}