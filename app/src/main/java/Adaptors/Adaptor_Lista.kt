package Adaptors

import DataClasses.Meniu_Item
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ProiectSI.R
import com.google.android.material.imageview.ShapeableImageView

class Adaptor_Lista(val tip: Tip_Adaptor, val mlist:ArrayList<Meniu_Item>, val clickListener: onClickListener, val longPressListener: onLongPressListener):RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    interface onClickListener{
        fun oncardClick(position:Int, itemviewholder: RecyclerView.ViewHolder)
    }
    interface onLongPressListener{
        fun onCardLongPress(position:Int, itemviewholder: RecyclerView.ViewHolder)
    }


    class ItemMeniu(itemView: View): RecyclerView.ViewHolder(itemView) {
        // val title_view:TextView=itemView.findViewById(R.id.alarmTitle)

        //instantierea obiectelor pt utilizare in cod
        val titlu:TextView = itemView.findViewById(R.id.Titlu)
        val pret: TextView = itemView.findViewById(R.id.Pret)
        val imagine: ShapeableImageView=itemView.findViewById(R.id.imageView)
    }

    class ItemComanda(itemView:View):RecyclerView.ViewHolder(itemView){

    }
    class ItemChecklist(itemView:View):RecyclerView.ViewHolder(itemView){

    }
    class ItemAngajat(itemView:View):RecyclerView.ViewHolder(itemView){

    }





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {


        val view: View
        when(tip){
            Tip_Adaptor.meniu -> {
                view= LayoutInflater.from(parent.context).inflate(R.layout.exemplu_item_meniu,parent,false)
            }

            Tip_Adaptor.check -> TODO()
            Tip_Adaptor.comanda -> TODO()
            Tip_Adaptor.angajat -> TODO()
        }


        return ItemMeniu(view)
    }

    override fun getItemCount(): Int {
        return mlist.size
    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {


        val mancare = mlist[position]

        if (holder is ItemMeniu) {

            holder.titlu.text = mancare.name
            holder.pret.text = "${mancare.price.toString()} RON"


        } else if (holder is ItemComanda) {


        }else if(holder is ItemChecklist){


        }else if(holder is ItemAngajat){


        }










        holder.itemView.setOnClickListener{
            clickListener.oncardClick(position, holder)
        }

        holder.itemView.setOnLongClickListener {
            longPressListener.onCardLongPress(position,holder)
            true
        }


    }

}



