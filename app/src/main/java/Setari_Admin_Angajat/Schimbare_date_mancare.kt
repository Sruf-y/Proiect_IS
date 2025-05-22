package Setari_Admin_Angajat;

import Adaptors.Adaptor_Lista
import Adaptors.Tip_Adaptor
import DataClasses.GlobalVars
import DataClasses.Meniu_Item
import android.content.Intent
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.ProiectSI.R;

class Schimbare_date_mancare(): AppCompatActivity(),Adaptor_Lista.onClickListener, Adaptor_Lista.onLongPressListener  {

    lateinit var adaptor: Adaptor_Lista<Meniu_Item>
    lateinit var recycler: RecyclerView
    lateinit var layoutmanager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schimbare_date_mancare)


        recycler = findViewById(R.id.recycler)
        adaptor=Adaptor_Lista(Tip_Adaptor.meniu, GlobalVars.lista_items_in_meniu_static,this,this,this)
        layoutmanager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        recycler.apply {
            adapter = adaptor
            layoutManager = layoutmanager
            setHasFixedSize(true) // Improves performance if item size is fixed
        }
        adaptor.notifyDataSetChanged()



    }

    override fun oncardClick(
        position: Int,
        itemviewholder: RecyclerView.ViewHolder
    ) {
        val intent = Intent(this, Adaugare_Mancare::class.java)
        intent.putExtra("item",adaptor.mlist[position])
        startActivity(intent)

    }

    override fun onCardLongPress(
        position: Int,
        itemviewholder: RecyclerView.ViewHolder
    ) {

        GlobalVars.lista_items_in_meniu_static.removeAt(position)
        adaptor.notifyDataSetChanged()
    }

    override fun onResume() {
        super.onResume()
        adaptor.notifyDataSetChanged()
    }

}