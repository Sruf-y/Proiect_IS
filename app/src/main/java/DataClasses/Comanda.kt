package DataClasses

import android.os.Parcelable
import com.ProiectSI.KotlinUtils.Companion.toBoolean
import kotlinx.parcelize.Parcelize
import kotlin.random.Random

@Parcelize
class Comanda(var id:String =randomizeID(),
              var list:ArrayList<Meniu_Item> = ArrayList<Meniu_Item>(),
              var listNumberOfs:ArrayList<Int> = ArrayList<Int>(),
              var timp_asteptare:Int = 0,
              var stare:StareComanda = StareComanda.Nelasata) : Parcelable {


    constructor(lista: ArrayList<Meniu_Item>,lista_numbers:ArrayList<Int>,timp_asteptare:Int):this(){
        this.list=lista
        this.listNumberOfs= lista_numbers
        this.timp_asteptare=timp_asteptare
    }

    fun addItem(item: Meniu_Item,numar:Int): Boolean{
        return if(list.add(item) && listNumberOfs.add(numar)){
            true
        }
        else{
            false
        }
    }

    fun removeItem(item: Meniu_Item): Boolean{
        return if(listNumberOfs.removeAt(list.indexOf(item)).toBoolean && list.remove(item)){
            true
        }
        else
            false
    }


    fun setAt(index:Int,item: Meniu_Item,numar: Int=0){
        if(list.size>index){
            list[index]=item
            listNumberOfs[index]=numar
        }
    }




    companion object{
        fun randomizeID(): String {
            val randomizer = Random

            val alphabet = listOf("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ")

            var string =""

            do{
                string =""

                for(i in 0..5){
                    string+=alphabet[randomizer.nextInt(0,alphabet.size-1)]
                }
            }while (GlobalVars.lista_Comenzi.map { p->p.id }.contains(string))


            return string
        }
    }


}