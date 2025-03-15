package VizualizareComanda

import Adaptors.MeniuAdaptor_Lista
import DataClasses.Meniu_Item
import Start_Activity.lista_items_in_meniu_static
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ProiectSI.R


class FragmentComanda : Fragment(R.layout.fragment_comanda),MeniuAdaptor_Lista.onClickListener,MeniuAdaptor_Lista.onLongPressListener {




    override fun oncardClick(position: Int, itemviewholder: RecyclerView.ViewHolder) {
        // open activity where to put items in cart
    }

    override fun onCardLongPress(position: Int, itemviewholder: RecyclerView.ViewHolder) {
        // make popup to show details about ingredients
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