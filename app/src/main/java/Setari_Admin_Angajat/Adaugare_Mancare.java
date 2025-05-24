package Setari_Admin_Angajat;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ProiectSI.R;

import java.util.ArrayList;
import java.util.List;

import DataClasses.Categorie;
import DataClasses.Meniu_Item;
import Functii_Utils.Functii;
import DataClasses.GlobalVars;
import Start_Activity.File_Salvate;


public class Adaugare_Mancare extends AppCompatActivity {

    Meniu_Item myitem=null;

    String previousname ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_adaugare_mancare);
        // asa utilizez o variabila ce a fost facuta globala in StartActivity
        GlobalVars.INSTANCE.getLista_items_in_meniu_static();

        myitem = getIntent().getParcelableExtra("item",Meniu_Item.class);

        if(myitem!=null){
            previousname = myitem.getName();
        }

        TextView bigtitle = findViewById(R.id.bigTitle);

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


        if(myitem!=null){
            denumire.setText(String.valueOf(myitem.getName()));
            numeimagine.setText(String.valueOf(myitem.getImage_id()));
            descriere.setText(String.valueOf(myitem.getDescription()));
            pret.setText(String.valueOf(myitem.getPrice()));
            valabil.setChecked(myitem.isAvailable());
            valorinutirionale.setText(String.valueOf(myitem.getNutritionDescription()));
            switch(myitem.getCategory()){
                case aperitiv:
                    tipSpinner.setSelection(0);
                    break;
                case fel_principal:
                    tipSpinner.setSelection(1);
                    break;
                case spirtoase:
                    tipSpinner.setSelection(2);
                    break;
                case nespirtoase:
                    tipSpinner.setSelection(3);
                    break;
            }

            bigtitle.setText("Editare Item: "+previousname);

        }

        ////////////////// Scrii codul aici/////////////////////////////////

        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(myitem!=null){
                    var a = GlobalVars.INSTANCE.getLista_items_in_meniu_static().stream().filter(p->p.getName().equals(previousname)).findFirst().get();
                    a.setName(denumire.getText().toString());
                    a.setImage_id(Integer.parseInt(numeimagine.getText().toString()));
                    a.setDescription(descriere.getText().toString());
                    a.setPrice(Double.parseDouble(pret.getText().toString()));
                    a.setAvailable(valabil.isChecked());
                    a.setNutritionDescription(valorinutirionale.getText().toString());
                    a.setCategory(tip[0]);

                    Functii.Companion.SaveAsJson(Adaugare_Mancare.this, File_Salvate.Lista_Meniu.name(),GlobalVars.INSTANCE.getLista_items_in_meniu_static());
                    finish();
                }else{


                    Meniu_Item item = new Meniu_Item(Integer.parseInt(numeimagine.getText().toString()),
                            denumire.getText().toString(),
                            tip[0],
                            Double.parseDouble(pret.getText().toString()),
                            valabil.isChecked(),
                            descriere.getText().toString(),
                            valorinutirionale.getText().toString());
                    GlobalVars.INSTANCE.getLista_items_in_meniu_static().add(item);
                    Functii.Companion.SaveAsJson(Adaugare_Mancare.this, File_Salvate.Lista_Meniu.name(),GlobalVars.INSTANCE.getLista_items_in_meniu_static());
                    finish();
                }
            }
        });





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