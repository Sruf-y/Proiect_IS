package DataClasses

import com.ProiectSI.KotlinUtils.Companion.toBoolean


class Comanda() {
    var list= ArrayList<Meniu_Item>()
    var listNumberOfs = ArrayList<Int>()
    var timp_asteptare:Int = 0
    var stare:StareComanda = StareComanda.Nelasata

    constructor(lista: java.util.ArrayList<Meniu_Item>,timp_asteptare:Int):this(){
        this.list=lista
        this.listNumberOfs= MutableList(lista.size) { 0 } as ArrayList<Int>
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




}