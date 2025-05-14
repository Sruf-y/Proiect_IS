package Adaptors

import DataClasses.Comanda
import DataClasses.GlobalVars
import DataClasses.StareComanda
import android.content.Context
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getColor
import androidx.recyclerview.widget.RecyclerView
import com.ProiectSI.R

class Comanda_Angajat_Adaptor(val context:Context,val onLongClickDo:((Comanda)->Unit)): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val mList:ArrayList<Comanda>
        get() {return GlobalVars.lista_Comenzi }


    inner class itemInList(itemView:View):RecyclerView.ViewHolder(itemView){
        val id: TextView=itemView.findViewById(R.id.comanda_id)
        val stare_text: TextView=itemView.findViewById(R.id.comanda_stare_text)
        val stare_vizual: ConstraintLayout=itemView.findViewById(R.id.comanda_stare_vizual)
        val main: ConstraintLayout = itemView.findViewById(R.id.main)








        fun bind(comanda: Comanda){

            fun nextState(){
                when(comanda.stare){
                    StareComanda.Plasata -> {
                        comanda.stare= StareComanda.In_Progres
                    }
                    StareComanda.In_Progres -> {
                        comanda.stare= StareComanda.Completa
                    }
                    else->{}
                }
            }


            id.text=comanda.id

            var color=R.color.gray

            fun setStareCOlor(){
                when(comanda.stare){
                    StareComanda.Plasata -> {
                        color=R.color.yellow
                    }
                    StareComanda.Completa -> {
                        color=R.color.activated
                    }
                    StareComanda.In_Progres -> {
                        color=R.color.indigo
                    }
                    else->{
                        color=R.color.gray
                    }
                }

                stare_text.text=comanda.stare.name

                stare_vizual.backgroundTintList= ColorStateList.valueOf(getColor(context,color))
            }






            itemView.setOnClickListener {

                nextState()

                setStareCOlor()



            }

            itemView.setOnLongClickListener {
                onLongClickDo.invoke(comanda)
                true
            }


        }
    }




    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.exemplu_comanda,parent,false)

        return itemInList(view)
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {

        (holder as itemInList).apply {




            bind(mList[position])



        }

    }

    override fun getItemCount(): Int {
        return mList.size
    }
}