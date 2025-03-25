package Setari_Admin_Angajat;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ProiectSI.R;

import java.util.ArrayList;

import DataClasses.Meniu_Item;
import Start_Activity.GlobalVars;
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
    }
}