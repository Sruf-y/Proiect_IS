package Start_Activity;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ProiectSI.R;

import Setari_Admin_Angajat.Creare_Cont_Angajat;


public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_admin);



        String angajatName = getIntent().getStringExtra("arg1");
        String angajatPassword = getIntent().getStringExtra("arg2");
        boolean isAdmin = "admin".equals(getIntent().getStringExtra("arg3"));


        // AICI SCRII CODUL

        Button buton_creare_angajat = findViewById(R.id.admin_buton_adaugare_angajat);

        if(isAdmin) {

            buton_creare_angajat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent_nou = new Intent(AdminActivity.this, Creare_Cont_Angajat.class);
                    startActivity(intent_nou);
                }
            });


        }
        else{
            buton_creare_angajat.setVisibility(View.GONE);
        }







    }
}












