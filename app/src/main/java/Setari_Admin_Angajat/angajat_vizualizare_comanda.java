package Setari_Admin_Angajat;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.ProiectSI.R;

import Adaptors.Comanda_Angajat_Adaptor;
import Setari_Admin_Angajat.SubFolder.viz_com_full;

public class angajat_vizualizare_comanda extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_angajat_vizualizare_comanda);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        var adaptor = new Comanda_Angajat_Adaptor(this,(comanda)->{
            Intent intent = new Intent(this, viz_com_full.class);
            intent.putExtra("comanda", comanda);

            return null;
        });

        /*
        * Sa se defineasca recyclerview din  R.layout.activity_angajat_vizualizare_comanda ca variabila
        *
        * Sa i se seteze layoutManager pentru recycler ca LinearLayoutManager
        *
        * Sa i se seteze adapter pentru recycler ca adaptor (cel creat mai sus)
        *
        *
        * Sa fie invocata metoda recyclerview_name.getAdapter().notifyDataSetChanged();
        *
        * */




    }
}