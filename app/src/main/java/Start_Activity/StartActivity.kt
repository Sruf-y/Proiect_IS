package Start_Activity

import DataClasses.Angajat
import DataClasses.Meniu_Item
import FragmentMeniu.FragmentMeniu
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

@JvmField
var lista_Comanda= ArrayList<Meniu_Item>()// lista de cele cumparate

@JvmField
var lista_items_in_meniu_static = ArrayList<Meniu_Item>() // lista cu toate mancarurile pe care le avem. Se initializeaza chiar aici
@JvmField
val lista_Angajati = ArrayList<Angajat>();


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

    private fun makeCurrentFragment(fragment: Fragment,container:FragmentContainerView) {
        supportFragmentManager.beginTransaction().apply {
            replace(container.id,fragment)
            commit();
        }
    }

}


fun customToast(whereToShowIt: View, context: Context, message: String) {
    val tost = Toast.makeText(context, message, Toast.LENGTH_SHORT);


    tost.show();
}