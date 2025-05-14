package Start_Activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ProiectSI.R;

import DataClasses.GlobalVars;
import Setari_Admin_Angajat.Adaugare_Mancare;
import Setari_Admin_Angajat.Creare_Cont_Angajat;
import Setari_Admin_Angajat.Schimbare_Date_Angajati;
import Setari_Admin_Angajat.Schimbare_Valabilitate_Item_Angajat;
import Setari_Admin_Angajat.Schimbare_date_mancare;
import Setari_Admin_Angajat.angajat_vizualizare_comanda;


public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_admin);


        String angajatName = getIntent().getStringExtra("arg1");
        String angajatPassword = getIntent().getStringExtra("arg2");
        boolean isAdmin = "admin".equals(getIntent().getStringExtra("arg3"));


        // AICI SCRII CODUL


        //buton Adaugare angajat
        Button button_creare_angajat = findViewById(R.id.admin_buton_adaugare_angajat);
        //button Schimbare date item din meniu
        Button button_schimbare_date_item_meniu = findViewById(R.id.admin_setari_meniu);
        //button Conturi Angajati
        Button button_admin_vizualizare_conturi_angajati = findViewById(R.id.admin_vizualizare_conturi_angajati);



        if (isAdmin) {
            button_creare_angajat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent_nou = new Intent(AdminActivity.this, Creare_Cont_Angajat.class);
                    startActivity(intent_nou);

                }
            });

            button_schimbare_date_item_meniu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent_nout = new Intent(AdminActivity.this, Schimbare_date_mancare.class);
                    startActivity(intent_nout);
                }
            });

            button_admin_vizualizare_conturi_angajati.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent_nou = new Intent(AdminActivity.this, Schimbare_Date_Angajati.class);
                    startActivity(intent_nou);
                }
            });






        } else {
            button_creare_angajat.setVisibility(View.GONE);
            button_schimbare_date_item_meniu.setVisibility(View.GONE);
            button_admin_vizualizare_conturi_angajati.setVisibility(View.GONE);
        }

        //Button adaugare item
        Button buton_adaugare_item = findViewById(R.id.admin_adaugare_item);
        buton_adaugare_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_nou = new Intent(AdminActivity.this, Adaugare_Mancare.class);
                startActivity(intent_nou);
            }
        });


        Button button_agnajat_schimba_valabilitate = findViewById(R.id.angajat_schimbare_valabilitate);

        button_agnajat_schimba_valabilitate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  Intent intent_nou=new Intent(AdminActivity.this, Schimbare_Valabilitate_Item_Angajat.class );
                  startActivity(intent_nou);
            }
        });


        //button vizualizarea comenzii        NECOMPLETATA
        Button button_admin_vizualizare_comenzi = findViewById(R.id.admin_vizualizare_comenzi);

        button_admin_vizualizare_comenzi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  Intent intent_nou=new Intent(AdminActivity.this, angajat_vizualizare_comanda.class );
                  startActivity(intent_nou);
            }
        });




    }
}