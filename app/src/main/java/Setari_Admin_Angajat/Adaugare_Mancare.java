package Setari_Admin_Angajat;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ProiectSI.R;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import DataClasses.Categorie;
import DataClasses.Meniu_Item;
import Functii_Utils.Functii;
import DataClasses.GlobalVars;
import Start_Activity.StartActivity;
import kotlin.jvm.internal.MutableLocalVariableReference;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.GlobalScope;



public class Adaugare_Mancare extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_adaugare_mancare);
        // asa utilizez o variabila ce a fost facuta globala in StartActivity
        GlobalVars.INSTANCE.getLista_items_in_meniu_static();



        Spinner tipSpinner = findViewById(R.id.spinner);
        final Categorie[] tip = {Categorie.aperitiv};



        ArrayList<String> spinner_list = new ArrayList<String>(List.of("Aperitiv","Fel Principal","Bautura Spirtoasa","Bautura nespirtoasa"));
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_item_resource,spinner_list);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        tipSpinner.setAdapter(adapter);
        String spinner_selection=spinner_list.get(0);
        tipSpinner.setSelection(0);

        tipSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch(tipSpinner.getSelectedItemPosition()){
                    case 0:
                        tip[0] = Categorie.aperitiv;
                        break;

                    case 1:
                        tip[0] = Categorie.fel_principal;
                        break;

                    case 2:
                        tip[0] = Categorie.spirtoase;
                        break;

                    case 3:
                        tip[0] = Categorie.nespirtoase;
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        EditText denumire = findViewById(R.id.editTextText2);
        EditText numeimagine = findViewById(R.id.editImagine);
        EditText valorinutirionale = findViewById(R.id.valorinutritionale);
        //tipSpinner este deja configurat, doar folosesti tip[0]
        EditText descriere = findViewById(R.id.editTextDescriere);
        EditText pret = findViewById(R.id.editTextPret);
        CheckBox valabil = findViewById(R.id.checkBox);
        Button buton = findViewById(R.id.admin_confirmare);



        ////////////////// Scrii codul aici/////////////////////////////////







        ///////////////////////////////////////////////////////////////////


    }







    @Override
    protected void onPause() {
        super.onPause();


        // Salvarea unei liste/valori.
        Functii.Companion.SaveAsJson(Adaugare_Mancare.this,"Lista_Meniu",GlobalVars.INSTANCE.getLista_items_in_meniu_static());
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Functia este null-safe. Asa se incarca din fisier daca exista o lista/valoare salvata.
        //Type aux = new TypeToken<ArrayList<Meniu_Item>>(){}.getType();
        //GlobalVars.INSTANCE.setLista_items_in_meniu_static(Functii.Companion.LoadFromJson(Adaugare_Mancare.this,"Lista_Meniu",GlobalVars.INSTANCE.getLista_items_in_meniu_static()));
    }
}