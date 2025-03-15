package Adaptors

import DataClasses.Meniu_Item
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ProiectSI.R

class Adaptor_Comenzi(val mlist:ArrayList<Meniu_Item>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        // val title_view:TextView=itemView.findViewById(R.id.alarmTitle)

        //instantierea obiectelor pt utilizare in cod
        val textbox = itemView.findViewById<TextView>(R.id.textView)

    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {


        val view= LayoutInflater.from(parent.context).inflate(R.layout.exemplu_item_meniu,parent,false)

        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mlist.size
    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {


        val item = mlist[position]




















    }

}



