package Start_Activity;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ProiectSI.MainActivity;
import com.ProiectSI.R;

import DataClasses.Meniu_Item;
import Setari_Admin_Angajat.Adaugare_Mancare;
import Setari_Admin_Angajat.Creare_Cont_Angajat;
import Setari_Admin_Angajat.Schimbare_Date_Angajati;
import Setari_Admin_Angajat.Schimbare_date_mancare;
import Setari_Admin_Angajat.Stergere_Conturi_Angajati;


public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // enableEdgeToEdge();
        setContentView(R.layout.activity_admin);

        // ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
        //     val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        //     v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
        //     return insets;
        // });

        String angajatName = getIntent().getStringExtra("arg1");
        String angajatPassword = getIntent().getStringExtra("arg2");
        boolean isAdmin = "admin".equals(getIntent().getStringExtra("arg3"));


        // AICI SCRII CODUL

    Button button_creare_angajat=findViewById(R.id.admin_buton_adaugare_angajat);

    if(isAdmin) {
        button_creare_angajat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_nou = new Intent(AdminActivity.this, Creare_Cont_Angajat.class);
                startActivity(intent_nou);

            }
        });
         }
    else{
        button_creare_angajat.setVisibility(View.GONE);
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

        //button Schimbare date item din meniu
        Button button_schimbare_date_item_meniu = findViewById(R.id.admin_schimbare_date_item_meniu);

        if(isAdmin) {
            button_schimbare_date_item_meniu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent_nout = new Intent(AdminActivity.this, Schimbare_date_mancare.class);
                    startActivity(intent_nout);
                }
            });
        }else {
            button_schimbare_date_item_meniu.setVisibility(View.GONE);
        }

        //button Conturi Angajati
        Button button_admin_vizualizare_conturi_angajati=findViewById(R.id.admin_vizualizare_conturi_angajati);

        if(isAdmin) {
            button_admin_vizualizare_conturi_angajati.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent_nou = new Intent(AdminActivity.this, Schimbare_Date_Angajati.class);
                    startActivity(intent_nou);
                }
            });
        }else{
            button_admin_vizualizare_conturi_angajati.setVisibility(View.GONE);
        }

        //button stergere cont angajat
        Button button_admin_stergere_cont_angajati=findViewById(R.id.admin_stergere_cont_angajati);

        if(isAdmin){
        button_admin_stergere_cont_angajati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_nou=new Intent(AdminActivity.this, Stergere_Conturi_Angajati.class);
                startActivity(intent_nou);
            }
        });
        }else{
            button_admin_stergere_cont_angajati.setVisibility(View.GONE);
        }

        //button vizualizarea comenzii        NECOMPLETATA
        Button button_admin_vizualizare_comenzi=findViewById(R.id.admin_vizualizare_comenzi);

        button_admin_vizualizare_comenzi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Intent intent_nou=new Intent(AdminActivity.this, /*vizualizare comanda*/ );
              //  startActivity(intent_nou);
            }
        });

        //button Stergere item din meniu        NECOMPLETATA
        Button button_admin_stergere_item_din_meniu=findViewById(R.id.admin_stergere_item_din_meniu);

        button_admin_stergere_item_din_meniu.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent intent_nou=new Intent(AdminActivity.this, /*stergere item din meniu . class*/ );
               // startActivity(intent_nou);
            }
        }));




    }
}