package VizualizareComanda

import Adaptors.MeniuAdaptor_Lista
import DataClasses.Meniu_Item
import Start_Activity.GlobalVars.cos_comanda
import Start_Activity.GlobalVars.lista_Comenzi
import Start_Activity.GlobalVars.lista_items_in_meniu_static
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ProiectSI.Login_Activity
import com.ProiectSI.R
import com.google.android.material.imageview.ShapeableImageView


class FragmentComanda : Fragment(R.layout.fragment_comanda),MeniuAdaptor_Lista.onClickListener,MeniuAdaptor_Lista.onLongPressListener {




    override fun oncardClick(position: Int, itemviewholder: RecyclerView.ViewHolder) {
        // open activity where to put items in cart
    }

    override fun onCardLongPress(position: Int, itemviewholder: RecyclerView.ViewHolder) {
        // make popup to show details about ingredients
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setarea recycler-ului
        val recycler:RecyclerView = requireView().findViewById(R.id.recyclercomanda)
        recycler.layoutManager=LinearLayoutManager(requireContext())


        //val adaptor= MeniuAdaptor_Lista(cos_comanda.list,this,this) // CORECT
        val adaptor= MeniuAdaptor_Lista(lista_items_in_meniu_static,this,this) // INCORECT
        recycler.adapter=adaptor
        recycler.adapter?.notifyDataSetChanged()




        val auth_buton: ImageView = requireView().findViewById(R.id.login_button1)


        auth_buton.setOnClickListener{

            val intent = Intent(requireContext(),Login_Activity::class.java)
            startActivity(intent)
        }

        val buton_adaugare_temp: ImageView = requireView().findViewById(R.id.butonaddTemporar_)

        buton_adaugare_temp.setOnClickListener {
            lista_items_in_meniu_static.add(Meniu_Item("Mamaliga"))
            lista_items_in_meniu_static.add(Meniu_Item("Mamaliga fiarta"))
            lista_items_in_meniu_static.add(Meniu_Item("Supa"))
            lista_items_in_meniu_static.add(Meniu_Item("Sarmale"))

            recycler.adapter?.notifyDataSetChanged()

        }






    }





    override fun onResume() {
        super.onResume()

        val recycler:RecyclerView = requireView().findViewById(R.id.recyclercomanda)
        recycler.layoutManager=LinearLayoutManager(requireContext());

        val adaptor= MeniuAdaptor_Lista(lista_items_in_meniu_static,this,this);
        recycler.adapter=adaptor

        recycler.adapter?.notifyDataSetChanged()



    }
}