package Adaptors

import Adaptors.Comanda_Angajat_Adaptor.itemInList
import DataClasses.Angajat
import DataClasses.GlobalVars
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.compose.ui.unit.Constraints
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.ProiectSI.R

class Angajat_Adaptor(val onClick:(Angajat)->Unit,val onLongClick:(Angajat)->Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val mList: ArrayList<Angajat>
        get() = GlobalVars.lista_Angajati

    inner class adapAngajat(itemView:View):RecyclerView.ViewHolder(itemView){
        val nameView: TextView = itemView.findViewById(R.id.name)
        val passView: TextView = itemView.findViewById(R.id.password)
        val main: ConstraintLayout = itemView.findViewById(R.id.main)

        fun bind(angajat:Angajat){
            nameView.text = angajat.username

            var passtring =""
            for(i in angajat.password.indices){
                passtring+="*"
            }

            passView.text = passtring


            main.setOnClickListener {
                onClick.invoke(angajat)
            }

            main.setOnLongClickListener {

                onLongClick.invoke(angajat)
                true
            }

        }

    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {

        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.exemplu_angajat,parent,false)
        return adapAngajat(view)
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        (holder as adapAngajat).apply {


            bind(mList[position])

        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}