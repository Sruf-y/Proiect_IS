package Adaptors

import DataClasses.Categorie
import DataClasses.GlobalVars
import DataClasses.Meniu_Item
import Functii_Utils.Functii
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.TextView
import androidx.appcompat.app.ActionBar.LayoutParams
import androidx.cardview.widget.CardView
import androidx.compose.ui.unit.Constraints
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.marginBottom
import androidx.recyclerview.widget.RecyclerView
import com.ProiectSI.KotlinUtils.Companion.dP
import com.ProiectSI.R
import com.google.android.material.checkbox.MaterialCheckBox
import com.google.android.material.imageview.ShapeableImageView

class Adaptor_Lista<T>(val tip: Tip_Adaptor, val lista:ArrayList<T>, val context: Context, val clickListener: onClickListener, val longPressListener: onLongPressListener, val filtru: Categorie?=null):RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    val mlist: ArrayList<T>
        get(){if(tip == Tip_Adaptor.meniu && filtru!=null)
                    return ArrayList<Meniu_Item>((lista as ArrayList<Meniu_Item>).filter { p->p.category== filtru }.filter { p->p.isAvailable }) as ArrayList<T>
                else
                    return lista
        }

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
        val card:CardView = itemView.findViewById(R.id.card)
        val info:ImageView = itemView.findViewById(R.id.imageView7)
    }

    class ItemComanda(itemView:View):RecyclerView.ViewHolder(itemView){
        val titlu:TextView = itemView.findViewById(R.id.Titlu)
        val pret: TextView = itemView.findViewById(R.id.Pret)
        val imagine: ShapeableImageView=itemView.findViewById(R.id.imageView)
        val card:CardView = itemView.findViewById(R.id.card)
        val numberOf: TextView=itemView.findViewById(R.id.numberOf)
    }
    class ItemChecklist(itemView:View):RecyclerView.ViewHolder(itemView){
        val titlu:TextView = itemView.findViewById(R.id.titlu)
        val checkbox:MaterialCheckBox = itemView.findViewById(R.id.ValabilCheckBox)

        val card:CardView = itemView.findViewById(R.id.card)
        val overlay: ConstraintLayout = itemView.findViewById(R.id.overlay)
    }
    class ItemAngajat(itemView:View):RecyclerView.ViewHolder(itemView){

    }





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {


        val view: View
        when(tip){
            Tip_Adaptor.meniu -> {
                view= LayoutInflater.from(parent.context).inflate(R.layout.exemplu_item_meniu,parent,false)
                return ItemMeniu(view)
            }

            Tip_Adaptor.check -> {
                view= LayoutInflater.from(parent.context).inflate(R.layout.exemplu_item_angajat_checkbox,parent,false)
                return ItemChecklist(view)
            }

            Tip_Adaptor.comanda -> {
                view= LayoutInflater.from(parent.context).inflate(R.layout.exemplu_item_meniu,parent,false)
                return ItemComanda(view)
            }

            Tip_Adaptor.angajat -> TODO()
        }


    }

    override fun getItemCount(): Int {
        return mlist.size
    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {


        when(holder){
            is ItemMeniu->{
                val mancare = mlist[position] as Meniu_Item

                holder.titlu.isSingleLine=false

                holder.imagine.layoutParams.height=130F.dP

                holder.titlu.text = mancare.name
                holder.pret.text = "${"%.2f".format(mancare.price)} RON"

                (holder.card.layoutParams as RecyclerView.LayoutParams).setMargins(10.dP,5.dP,10.dP,5.dP)

                holder.info.setOnClickListener {
                    NutritionPopupDialog(context,mancare.nutritionDescription.trimIndent()).show()
                }
            }
            is ItemComanda->{
                try {


                    val mancare = mlist[position] as Meniu_Item

                    holder.titlu.isSingleLine = true
                    holder.titlu.text = mancare.name

                    holder.imagine.layoutParams.height = 90F.dP

                    (holder.card.layoutParams as RecyclerView.LayoutParams).setMargins(
                        10.dP,
                        8.dP,
                        10.dP,
                        8.dP
                    )
                    var numberOf=0
                    if(GlobalVars.comanda_in_cos.listNumberOfs.isNotEmpty())
                        numberOf = GlobalVars.comanda_in_cos.listNumberOfs[position]

                    holder.numberOf.apply {
                        visibility = View.VISIBLE
                        text = "x " + numberOf.toString()
                    }
                    holder.pret.text = "${"%.2f".format(mancare.price * numberOf)} RON"
                }catch (ex: Exception){
                    Log.e("Error","Adaptor_Lista exception at is ItemComanda: ",ex)
                }

            }
            is ItemChecklist->{
                val mancare = mlist[position] as Meniu_Item
                holder.titlu.text=mancare.name
                holder.titlu.isSingleLine=false

                holder.checkbox.isChecked=mancare.isAvailable

                holder.checkbox.setOnClickListener{


                    mancare.isAvailable=holder.checkbox.isChecked

                }

                holder.overlay.setOnClickListener {
                    clickListener.oncardClick(position,holder)
                }

                (holder.card.layoutParams as RecyclerView.LayoutParams).setMargins(10.dP,8.dP,10.dP,8.dP)

            }
            is ItemAngajat->{}

        }










        holder.itemView.setOnClickListener{
            clickListener.oncardClick(position, holder)
        }

        holder.itemView.setOnLongClickListener {
            longPressListener.onCardLongPress(position,holder)



            true
        }


    }

    fun updateList( newList:ArrayList<T>){

        mlist.clear()
        mlist.addAll(newList)
        notifyDataSetChanged()
    }

    fun addItemAt(item:T,position:Int,outsideList: ArrayList<T>? = null){

        if (outsideList != null && outsideList.size>=position) {
            outsideList.add(position,item)
        }

        mlist.add(position,item)
        notifyItemInserted(position)
    }
    fun removeItemAt(position:Int, outsideList: ArrayList<T>? = null){

        if (outsideList != null && outsideList.size>=position) {
            outsideList.removeAt(position)
        }
        mlist.removeAt(position)
        notifyItemRemoved(position)
    }



}



