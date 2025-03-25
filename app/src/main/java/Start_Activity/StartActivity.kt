package Start_Activity

import DataClasses.Angajat
import DataClasses.Comanda
import DataClasses.Meniu_Item
import FragmentMeniu.FragmentMeniu
import Functii_Utils.Functii
import Start_Activity.GlobalVars.lista_Angajati
import Start_Activity.GlobalVars.lista_Comenzi
import Start_Activity.GlobalVars.lista_items_in_meniu_static
import VizualizareComanda.FragmentComanda
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import com.ProiectSI.R
import com.google.android.material.bottomnavigation.BottomNavigationView



object GlobalVars{
    var lista_Comenzi= ArrayList<Comanda>() // lista cu toate comenzile de pana acum
    var cos_comanda= Comanda()// lista de cele cumparate


    var lista_items_in_meniu_static = ArrayList<Meniu_Item>() // lista cu toate mancarurile pe care le avem. Se initializeaza chiar aici

    var lista_Angajati = ArrayList<Angajat>();
}



class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_start)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }


        val navbar:BottomNavigationView= findViewById(R.id.navbar1)
        val frag_container:FragmentContainerView = findViewById(R.id.fragmentContainerView2)

        navbar.setOnItemSelectedListener { item ->

            when(item.itemId){
                R.id.meniu -> {
                    makeCurrentFragment(FragmentMeniu(), frag_container)
                    true
                }
                R.id.order -> {
                    makeCurrentFragment(FragmentComanda(), frag_container)
                    true
                }
                else->{
                makeCurrentFragment(FragmentMeniu(), frag_container)
                true
            }
            }
        }

        //adauga itemele din meniu aici







    }

    override fun onPause() {
        super.onPause()
        Functii.SaveAsJson(this,"Lista_Comenzi",lista_Comenzi)

        Functii.SaveAsJson(this,"Lista_Meniu",lista_items_in_meniu_static)

        Functii.SaveAsJson(this,"Lista_Angajati",lista_Angajati)

    }

    override fun onResume() {
        super.onResume()



        lista_Comenzi=Functii.LoadFromJson(this,"Lista_Comenzi",lista_Comenzi)

        lista_items_in_meniu_static=Functii.LoadFromJson(this,"Lista_Meniu",lista_items_in_meniu_static)

        lista_Angajati=Functii.LoadFromJson(this,"Lista_Angajati",lista_Angajati)
    }

    private fun makeCurrentFragment(fragment: Fragment,container:FragmentContainerView) {
        supportFragmentManager.beginTransaction().apply {
            replace(container.id,fragment)
            commit();
        }
    }

}