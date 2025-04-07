package VizualizareComanda

import Adaptors.Adaptor_Lista
import Adaptors.Tip_Adaptor
import DataClasses.Meniu_Item
import DataClasses.GlobalVars.lista_items_in_meniu_static
import Functii_Utils.Functii.Companion.CustomSnack
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ProiectSI.KotlinUtils.Companion.dP
import com.ProiectSI.Login_Activity
import com.ProiectSI.R
import java.util.ArrayList


class FragmentComanda : Fragment(R.layout.fragment_comanda),Adaptor_Lista.onClickListener,Adaptor_Lista.onLongPressListener {




    lateinit var recycler:RecyclerView

    lateinit var adaptor: Adaptor_Lista<Meniu_Item>
    lateinit var myContext:Context

    override fun oncardClick(position: Int, itemviewholder: RecyclerView.ViewHolder) {
        // open activity where to put items in cart
    }


    override fun onCardLongPress(position: Int, itemviewholder: RecyclerView.ViewHolder) {
        // make popup to show details about ingredients

        CustomSnack(
            whereToShowIt = itemviewholder.itemView,
            message = adaptor.mlist[position].nutritionDescription,
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        // Setarea recycler-ului

        initializeRecycler()


        //val adaptor= MeniuAdaptor_Lista(cos_comanda.list,this,this) // CORECT

        val checkoutButton = requireView().findViewById<TextView>(R.id.checkOutButton)
        (checkoutButton.layoutParams as ConstraintLayout.LayoutParams).apply {
        }

        val auth_buton: ImageView = requireView().findViewById(R.id.login_button1)


        auth_buton.setOnClickListener{

            val intent = Intent(requireContext(),Login_Activity::class.java)
            startActivity(intent)
        }

        val buton_adaugare_temp: ImageView = requireView().findViewById(R.id.butonaddTemporar_)

        buton_adaugare_temp.setOnClickListener {
            lista_items_in_meniu_static.clear()
            lista_items_in_meniu_static.add(Meniu_Item("Mamaliga"))
            lista_items_in_meniu_static.add(Meniu_Item("Mamaliga fiarta"))
            lista_items_in_meniu_static.add(Meniu_Item("Supa"))
            lista_items_in_meniu_static.add(Meniu_Item("Sarmale"))
            lista_items_in_meniu_static.add(Meniu_Item("Ciorba de cartofi"))
            lista_items_in_meniu_static.add(Meniu_Item("Supa de pui"))
            lista_items_in_meniu_static.add(Meniu_Item("Ochi de ou"))
            lista_items_in_meniu_static.add(Meniu_Item("Cartofi prajiti"))
            lista_items_in_meniu_static.add(Meniu_Item("Cartofi gratinati cu sos de musdei"))

            adaptor.updateList(lista_items_in_meniu_static)

        }





    }



    fun initializeRecycler(){
        myContext = requireContext()
        recycler = requireView().findViewById(R.id.recyclercomanda);
        recycler.layoutManager=LinearLayoutManager(context);
        recycler.adapter=Adaptor_Lista(Tip_Adaptor.comanda,ArrayList<Meniu_Item>(),myContext,this,this)
        adaptor= recycler.adapter as Adaptor_Lista<Meniu_Item>
        adaptor.updateList(lista_items_in_meniu_static)
        recycler.adapter?.notifyDataSetChanged()
    }


    override fun onResume() {
        super.onResume()

        initializeRecycler()



    }
}