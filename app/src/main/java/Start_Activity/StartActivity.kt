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
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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
        enableEdgeToEdge()
        setContentView(R.layout.activity_start)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }


        val navbar:BottomNavigationView= findViewById(R.id.navbar1)
        val frag_container:FragmentContainerView = findViewById(R.id.fragmentContainerView2)


        when(navbar.selectedItemId) {
            R.id.meniu -> {
                makeCurrentFragment(FragmentMeniu(), frag_container)
            }

            R.id.order -> {
                makeCurrentFragment(FragmentComanda(), frag_container)
            }

            else -> {
                makeCurrentFragment(FragmentMeniu(), frag_container)
            }
        }


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


    }

    private fun makeCurrentFragment(fragment: Fragment,container:FragmentContainerView) {
        supportFragmentManager.beginTransaction().apply {
            replace(container.id,fragment)
            commit();
        }
    }

}