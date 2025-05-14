package Setari_Admin_Angajat.SubFolder

import Adaptors.Adaptor_Lista
import Adaptors.Tip_Adaptor
import DataClasses.Comanda
import DataClasses.Meniu_Item
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ProiectSI.R

class viz_com_full : AppCompatActivity(),Adaptor_Lista.onClickListener,Adaptor_Lista.onLongPressListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_viz_com_full)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val comanda = intent.getParcelableExtra<Comanda>("comanda",Comanda::class.java)

        if(comanda!=null) {

            val recycler: RecyclerView = findViewById(R.id.recycler)

            val linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

            val adaptor = Adaptor_Lista(Tip_Adaptor.comanda, comanda.list, this, this, this)


            recycler.adapter=adaptor

            adaptor.notifyDataSetChanged()
        }







    }

    override fun oncardClick(
        position: Int,
        itemviewholder: RecyclerView.ViewHolder
    ) {

    }

    override fun onCardLongPress(
        position: Int,
        itemviewholder: RecyclerView.ViewHolder
    ) {

    }
}