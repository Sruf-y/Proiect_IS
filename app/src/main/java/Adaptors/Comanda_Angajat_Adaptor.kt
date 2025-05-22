package Adaptors

import DataClasses.Comanda
import DataClasses.GlobalVars
import DataClasses.GlobalVars.lista_Comenzi
import DataClasses.StareComanda
import Functii_Utils.Functii
import Start_Activity.File_Salvate
import android.content.Context
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.compose.ui.unit.min
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.getColor
import androidx.recyclerview.widget.RecyclerView
import com.ProiectSI.R
import com.google.android.material.imageview.ShapeableImageView

class Comanda_Angajat_Adaptor(val context:Context,val onLongClickDo:((Comanda)->Unit)): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val mList:ArrayList<Comanda>
        get() {return GlobalVars.lista_Comenzi }


    inner class itemInList(itemView:View):RecyclerView.ViewHolder(itemView){
        val id: TextView=itemView.findViewById(R.id.comanda_id)
        val stare_text: TextView=itemView.findViewById(R.id.comanda_stare_text)
        val stare_vizual: ConstraintLayout=itemView.findViewById(R.id.comanda_stare_vizual)
        val main: ConstraintLayout = itemView.findViewById(R.id.main)
        val plusButton: ShapeableImageView = itemView.findViewById(R.id.plusButton)
        val minusButton: ShapeableImageView = itemView.findViewById(R.id.minusButton)
        val timetextview: TextView = itemView.findViewById(R.id.textTimpComanda)







        fun bind(comanda: Comanda){
            id.text=comanda.id

            var color=R.color.gray

            timetextview.text = comanda.timp_asteptare.toString()

            if(comanda.stare== StareComanda.Neplasata){
                comanda.stare= StareComanda.Plasata
                color=R.color.yellow
            }

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
                Functii.SaveAsJson(context,File_Salvate.Lista_Comenzi.name,lista_Comenzi)
            }

            plusButton.setOnClickListener {
                comanda.timp_asteptare+=1

                // max 4 ore
                if(comanda.timp_asteptare>480){
                    comanda.timp_asteptare=480
                }

                timetextview.text = comanda.timp_asteptare.toString()
            }
            minusButton.setOnClickListener {
                comanda.timp_asteptare-=1

                if(comanda.timp_asteptare<0){
                    comanda.timp_asteptare=0
                }

                timetextview.text = comanda.timp_asteptare.toString()
            }




            fun setStareCOlor(){
                when(comanda.stare){
                    StareComanda.Neplasata ->{
                        color=R.color.gray
                    }
                    StareComanda.Plasata -> {
                        color=R.color.yellow
                    }
                    StareComanda.Completa -> {
                        color=R.color.activated

                        minusButton.visibility=View.INVISIBLE
                        plusButton.visibility=View.INVISIBLE
                        timetextview.text = "0"
                    }
                    StareComanda.In_Progres -> {
                        color=R.color.indigo
                        minusButton.visibility=View.INVISIBLE
                        plusButton.visibility=View.INVISIBLE
                    }

                }


                stare_text.text=comanda.stare.name

                stare_vizual.backgroundTintList= ColorStateList.valueOf(getColor(context,color))
            }

            setStareCOlor()





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