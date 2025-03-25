package Start_Activity;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ProiectSI.MainActivity;
import com.ProiectSI.R;
import com.ProiectSI.databinding.FragmentComandaBinding;

import Setari_Admin_Angajat.Adaugare_Mancare;
import Setari_Admin_Angajat.Creare_Cont_Angajat;
import Setari_Admin_Angajat.Schimbare_Date_Angajati;
import Setari_Admin_Angajat.Schimbare_date_mancare;
import Setari_Admin_Angajat.Stergere_Conturi_Angajati;
import VizualizareComanda.FragmentComanda;


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
//Button creare angajat
    Button button_creare_angajat=findViewById(R.id.admin_buton_adaugare_angajat);


        button_creare_angajat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_nou = new Intent(AdminActivity.this, Creare_Cont_Angajat.class);
                startActivity(intent_nou);

            }
        });

        //Adaugare Item button
Button button_Adaugare_Mancare=findViewById(R.id.admin_adaugare_item);

button_Adaugare_Mancare.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent_nou=new Intent(AdminActivity.this, Adaugare_Mancare.class );
        startActivity(intent_nou);
    }
});

//Schimbare date din meniu button
Button button_schimbare_date_item_meniu=findViewById(R.id.admin_schimbare_date_item_meniu);

button_schimbare_date_item_meniu.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent_nout=new Intent(AdminActivity.this, Schimbare_date_mancare.class);
        startActivity(intent_nout);
    }
});

//button schimbare cont angajat
Button button_admin_vizualizare_conturi_angajati=findViewById(R.id.admin_vizualizare_conturi_angajati);

button_admin_vizualizare_conturi_angajati.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent_nou=new Intent(AdminActivity.this, Schimbare_Date_Angajati.class);
        startActivity(intent_nou);
    }
});

//button stergere cont angajat
Button button_admin_stergere_cont_angajati=findViewById(R.id.admin_stergere_cont_angajati);

button_admin_stergere_cont_angajati.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent_nou=new Intent(AdminActivity.this, Stergere_Conturi_Angajati.class);
        startActivity(intent_nou);
    }
});

//button vizualizare comanda        NECOMPLETATA
Button button_admin_vizualizare_comenzi=findViewById(R.id.admin_vizualizare_comenzi);

button_admin_vizualizare_comenzi.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
       // Intent intent_nou=new Intent(AdminActivity.this, /*Nume vizualizare comanda .class*/);
       // startActivity(intent_nou);
    }
});

//Button Confirmarea      NECOMPLETATA
Button button_admin_confirmare=findViewById(R.id.admin_confirmare);

button_admin_confirmare.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        //Intent intent_nu=new Intent(AdminActivity.this, /*Nume Confirmare Comanda .class*/);
        // startActivity(intent_nou);
    }
});

//Buton modificare      NECOMPLETATA
Button button_admin_modificare= findViewById(R.id.admin_modificare);

button_admin_modificare.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        // Intent intent_nou=new Intent(AdminActivity.this, /*Nume modificare .class*/);
        // startActivity(intent_nou);
    }
});


    }
}