package Setari_Admin_Angajat

import Adaptors.Adaptor_Lista
import Adaptors.Tip_Adaptor
import DataClasses.GlobalVars
import DataClasses.GlobalVars.lista_items_in_meniu_static
import DataClasses.Meniu_Item
import Functii_Utils.Functii
import Start_Activity.File_Salvate
import android.content.Context
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ProiectSI.R
import org.w3c.dom.Text
import java.util.ArrayList

class Schimbare_Valabilitate_Item_Angajat : AppCompatActivity(),Adaptor_Lista.onClickListener,Adaptor_Lista.onLongPressListener {

    lateinit var myContext: Context
    lateinit var recycler: RecyclerView
    lateinit var adaptor:Adaptor_Lista<Meniu_Item>



    override fun oncardClick(position: Int, itemviewholder: RecyclerView.ViewHolder) {

        (itemviewholder as Adaptor_Lista.ItemChecklist).checkbox.performClick()
    }

    override fun onCardLongPress(position: Int, itemviewholder: RecyclerView.ViewHolder) {

    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_schimbare_valabilitate_item_angajat)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        initializeRecycler()

        val saveButton = findViewById<TextView>(R.id.textView6)

        saveButton.setOnClickListener {

            Functii.SaveAsJson(this,File_Salvate.Lista_Meniu.toString(), lista_items_in_meniu_static)
        }


    }

    override fun onResume() {
        super.onResume()
        initializeRecycler()

    }

    override fun onPause() {
        super.onPause()

        Functii.SaveAsJson(this,File_Salvate.Lista_Meniu.toString(), lista_items_in_meniu_static)
    }

    fun initializeRecycler(){
        myContext = this
        recycler = findViewById(R.id.recycler_checkboxes);
        recycler.layoutManager= LinearLayoutManager(myContext);
        recycler.adapter=
            Adaptor_Lista(Tip_Adaptor.check, lista_items_in_meniu_static,myContext,this,this,null,null)
        adaptor= recycler.adapter as Adaptor_Lista<Meniu_Item>
        recycler.adapter?.notifyDataSetChanged()
    }


}