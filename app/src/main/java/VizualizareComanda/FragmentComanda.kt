package VizualizareComanda

import Adaptors.Adaptor_Lista
import Adaptors.Tip_Adaptor
import DataClasses.Comanda
import DataClasses.GlobalVars
import DataClasses.Meniu_Item
import DataClasses.GlobalVars.lista_items_in_meniu_static
import DataClasses.StareComanda
import Functii_Utils.Functii.Companion.CustomSnack
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.compose.material3.VerticalDivider
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ProiectSI.AddItemsToCos
import com.ProiectSI.KotlinUtils.Companion.dP
import com.ProiectSI.Login_Activity
import com.ProiectSI.R
import java.util.ArrayList


class FragmentComanda : Fragment(R.layout.fragment_comanda),Adaptor_Lista.onClickListener,Adaptor_Lista.onLongPressListener {




    lateinit var recycler:RecyclerView

    lateinit var adaptor: Adaptor_Lista<Meniu_Item>
    lateinit var myContext:Context

    override fun oncardClick(position: Int, itemviewholder: RecyclerView.ViewHolder) {
        val intent = Intent(context, AddItemsToCos::class.java)
        intent.putExtra("item",adaptor.mlist[position])
        intent.putExtra("itemNr", GlobalVars.comanda_in_cos.listNumberOfs[position])
        startActivity(intent)
    }


    override fun onCardLongPress(position: Int, itemviewholder: RecyclerView.ViewHolder) {
        // make popup to show details about ingredients

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        // Setarea recycler-ului

        initializeRecycler()




        val checkoutButton = requireView().findViewById<TextView>(R.id.checkOutButton)
        (checkoutButton.layoutParams as ConstraintLayout.LayoutParams).apply {
        }

        val auth_buton: ImageView = requireView().findViewById(R.id.login_button1)


        auth_buton.setOnClickListener{

            val intent = Intent(requireContext(),Login_Activity::class.java)
            startActivity(intent)
        }

        val buton_adaugare_temp: ImageView = requireView().findViewById(R.id.butonaddTemporar_)



        val status_comanda: TextView=requireView().findViewById(R.id.status_comanda)


        if(GlobalVars.comanda_in_cos.stare!= StareComanda.Nelasata){
            status_comanda.visibility= View.VISIBLE
            status_comanda.text= "Status comanda: "+GlobalVars.comanda_in_cos.stare.toString().replace("_"," ")
        } else{
            status_comanda.visibility= View.GONE
        }





    }



    fun initializeRecycler(){
        myContext = requireContext()

        recycler = requireView().findViewById(R.id.recyclercomanda);

        recycler.layoutManager=LinearLayoutManager(context);

        recycler.adapter=Adaptor_Lista(Tip_Adaptor.comanda, ArrayList<Meniu_Item>(),myContext,this,this)

        adaptor= recycler.adapter as Adaptor_Lista<Meniu_Item>

        adaptor.updateList(GlobalVars.comanda_in_cos.list)
    }


    override fun onResume() {
        super.onResume()



        initializeRecycler()




    }
}