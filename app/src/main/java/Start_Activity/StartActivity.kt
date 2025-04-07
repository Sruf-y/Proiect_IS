package Start_Activity

import DataClasses.Categorie
import DataClasses.Meniu_Item
import FragmentMeniu.FragmentMeniu
import Functii_Utils.Functii
import DataClasses.GlobalVars.lista_Angajati
import DataClasses.GlobalVars.lista_Comenzi
import DataClasses.GlobalVars.lista_items_in_meniu_static
import VizualizareComanda.FragmentComanda
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import com.ProiectSI.R
import com.google.android.material.bottomnavigation.BottomNavigationView

enum class File_Salvate{
    Lista_Comenzi,
    Lista_Meniu,
    Lista_Angajati
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
        Functii.SaveAsJson(this,File_Salvate.Lista_Comenzi.name,lista_Comenzi)

        Functii.SaveAsJson(this,File_Salvate.Lista_Meniu.name,lista_items_in_meniu_static)

        Functii.SaveAsJson(this,File_Salvate.Lista_Angajati.name,lista_Angajati)

    }

    override fun onResume() {
        super.onResume()



        lista_Comenzi=Functii.KotlinLoadFromJson(this, File_Salvate.Lista_Comenzi.toString(),lista_Comenzi)

        lista_Angajati=Functii.KotlinLoadFromJson(this, File_Salvate.Lista_Angajati.toString(),lista_Angajati)

        lista_items_in_meniu_static= Functii.KotlinLoadFromJson(this,File_Salvate.Lista_Meniu.toString(),lista_items_in_meniu_static)

        Functii.CheckNewInstallLoadList(this)

        if(lista_items_in_meniu_static.isEmpty()) {

            lista_items_in_meniu_static.add(
                Meniu_Item(
                    -1,
                    "Mamaliguta Cu Ceapa",
                    Categorie.fel_principal,
                    24.5,
                    true,
                    "Mamaliga ca acasa facuta de bunica bucatareasa.",
                    "30g otet \n10g sare \n500ml lapte \n1kgmalai"
                )
            )
            lista_items_in_meniu_static.add(
                Meniu_Item(
                    -1,
                    "mancare de rata",
                    Categorie.spirtoase,
                    295.3,
                    false,
                    "",
                    ""

                )
            )





        }
    }

    private fun makeCurrentFragment(fragment: Fragment,container:FragmentContainerView) {
        supportFragmentManager.beginTransaction().apply {
            replace(container.id,fragment)
            commit();
        }
    }

}