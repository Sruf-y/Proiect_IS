package DataClasses



class Comanda() {
    var list= ArrayList<Meniu_Item>()
    var timp_asteptare:Int = 0
    var finalizata:Boolean =false

    constructor(lista: java.util.ArrayList<Meniu_Item>,timp_asteptare:Int):this(){
        this.list=lista
        this.timp_asteptare=timp_asteptare
    }

    constructor(item:Meniu_Item,timp_asteptare:Int):this(){
        this.list= ArrayList<Meniu_Item>(listOf<Meniu_Item>(item))
        this.timp_asteptare=timp_asteptare
    }

}