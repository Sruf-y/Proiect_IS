package Functii_Utils

import DataClasses.Angajat
import DataClasses.Categorie
import DataClasses.Comanda
import DataClasses.GlobalVars
import DataClasses.GlobalVars.chitante_lista_ughhhh
import DataClasses.GlobalVars.lista_items_in_meniu_static
import DataClasses.Meniu_Item
import Start_Activity.File_Salvate
import android.content.Context
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBar
import androidx.core.content.ContextCompat.getColor
import com.ProiectSI.R
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.io.ObjectInputStream


class Functii {


    companion object {

        fun WriteStringInFile(context: Context, filename: String, message: String) {

            try {

                val fos: FileOutputStream =
                    context.openFileOutput("$filename.txt", Context.MODE_PRIVATE)
                fos.write(message.toByteArray())
                fos.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

        fun CustomSnack(whereToShowIt: View, message: String) {
            val snack = Snackbar.make(whereToShowIt, message, Snackbar.LENGTH_SHORT)
            snack.animationMode = Snackbar.ANIMATION_MODE_FADE
            snack.apply {
                view.setOnClickListener {
                    dismiss()
                }

                behavior = object : BaseTransientBottomBar.Behavior() {
                    override fun canSwipeDismissView(child: View): Boolean {
                        return true
                    }
                }

                (view.layoutParams as FrameLayout.LayoutParams).apply {
                    width = ActionBar.LayoutParams.WRAP_CONTENT
                    gravity = Gravity.END or Gravity.BOTTOM
                }

                view.apply {
                    setBackgroundColor(getColor(context, R.color.gray))

                    setAnchorView(whereToShowIt)

                }
            }.show()
        }


        fun advancedSaveAsJson(context: Context, filename:String, data:Any,parent:File=context.filesDir) {

            if(!parent.exists()){
                parent.mkdirs()
            }

            val json=Gson().toJson(data);
            val Filename= "$filename.json"

            File(parent,Filename).writeText(json)
        }

        fun saveAsTextFile(context: Context, filename: String, text: String, parent: File = context.filesDir) {
            if (!parent.exists()) {
                parent.mkdirs()
            }


                val fullFilename = "$filename.txt"  // i'm using txt extension for text files
                File(parent, fullFilename).writeText(text)

        }


        fun <T> SaveAsJson(context: Context, filename: String, data: T) {
            val json = Gson().toJson(data)
            val filepath = context.filesDir.toString() + "/" + filename + ".json"

            File(filepath).writeText(json)
        }
        //exemplu utilizare in java


        // Functii.Companion.SaveAsJson(Adaugare_Mancare.this,"Lista_Meniu",GlobalVars.INSTANCE.getLista_items_in_meniu_static());


        inline fun <reified T> KotlinLoadFromJson(context: Context, filename: String, data: T): T {

            val filepath = context.filesDir.toString() + "/" + filename + ".json"
            val file = File(filepath)

            if (file.exists()) {
                val loadedFile = file.readText()
                val type = object : TypeToken<T>() {}.type
                val readData: T = Gson().fromJson(loadedFile, type)

                return readData
            }
            return data
        }


        fun <T> LoadFromJson(context: Context, filename: String, data: T): T {


            try {
                val f: FileInputStream =
                    FileInputStream(context.filesDir.toString() + "/" + filename + ".json")
                val ois: ObjectInputStream = ObjectInputStream(f)
                val o: Object = ois.readObject() as Object
                ois.close()
                f.close()
                return o as T
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return data
        }


        fun CheckNewInstallLoadList(context: Context) {

            if (lista_items_in_meniu_static.isEmpty()) {


                // BĂUTURI SPIRTOASE (Alcoholic Drinks)
                lista_items_in_meniu_static.add(
                    Meniu_Item(
                        R.drawable.mojito,
                        "Mojito",
                        Categorie.spirtoase,
                        23.20,
                        true,
                        "Cocktail cubanez cu rom și mentă",
                        """
        Ingrediente:
        - 50ml rom alb
        - 6 frunze de mentă proaspătă
        - 25ml sirop de zahăr
        - 25ml suc de lămâie proaspăt
        - Apă minerală
        - Gheață cuburi
        
        Alcool: 15% vol.
        Vegetarian: Da
        Picant: Nu
        Calorii: 214 kcal
        """
                    )
                )

                lista_items_in_meniu_static.add(
                    Meniu_Item(
                        R.drawable.whisky_single_malt,
                        "Whisky Single Malt",
                        Categorie.spirtoase,
                        22.00,
                        true,
                        "Băutură alcoolică îmbătrânită în butoi de stejar",
                        """
        Ingrediente:
        - Whisky single malt (40ml)
        - Gheață (opțional)
        
        Alcool: 40% vol.
        Vegetarian: Da
        Picant: Nu
        Calorii: 250 kcal
        """
                    )
                )

                lista_items_in_meniu_static.add(
                    Meniu_Item(
                        R.drawable.vin_rosu_sec,
                        "Vin Roșu Sec",
                        Categorie.spirtoase,
                        18.00,
                        true,
                        "Vin roșu sec de podgorie românească",
                        """
        Ingrediente:
        - Vin roșu (150ml)
        - Struguri: Merlot/Cabernet Sauvignon
        
        Alcool: 13% vol.
        Vegetarian: Da
        Picant: Nu
        Calorii: 125 kcal
        """
                    )
                )



                lista_items_in_meniu_static.add(
                    Meniu_Item(
                        R.drawable.bruschete_cu_rosii,
                        "Bruschete cu Roșii",
                        Categorie.aperitiv,
                        15.0,
                        true,
                        "Pâine prăjită cu roșii proaspete și busuioc",
                        """
        Ingrediente:
        - Pâine italiană
        - Roșii cherry
        - Busuioc proaspăt
        - Ulei de măsline
        - Usturoi
        - Sare
        
        Vegetarian: Da
        Picant: Nu
        """
                    )
                )

                lista_items_in_meniu_static.add(
                    Meniu_Item(
                        R.drawable.bruschete_cu_somon,
                        "Bruschete cu Somon",
                        Categorie.aperitiv,
                        22.0,
                        true,
                        "Pâine prăjită cu somon afumat și cremă de avocat",
                        """
        Ingrediente:
        - Pâine integrală
        - Somon afumat
        - Avocat
        - Lămâie
        - Mărar
        - Smântână
        
        Vegetarian: Nu
        Picant: Nu
        """
                    )
                )

// FELURI PRINCIPALE (Main Courses)


                lista_items_in_meniu_static.add(
                    Meniu_Item(
                        R.drawable.ciorba_de_burta_picanta,
                        "Ciorbă de Burtă Picantă",
                        Categorie.fel_principal,
                        28.0,
                        true,
                        "Ciorbă tradițională cu burtă și usturoi",
                        """
        Ingrediente:
        - Burtă de vită
        - Smântână
        - Usturoi
        - Ardei iute
        - Morcov
        - Pătrunjel
        
        Vegetarian: Nu
        Picant: Da (3/5 iuțeală)
        """
                    )
                )


                lista_items_in_meniu_static.add(
                    Meniu_Item(
                        R.drawable.limonada,
                        "Limonadă",
                        Categorie.nespirtoase,
                        12.0,
                        true,
                        "Limonadă naturală cu lămâie proaspătă",
                        """
        Ingrediente:
        - Apă minerală
        - Lămâie
        - Frunze de mentă
        - Fructoză (opțional)
        
        Vegetarian: Da
        Picant: Nu
        """
                    )
                )


                lista_items_in_meniu_static.add(
                    Meniu_Item(R.drawable.mamaliga_cu_ceapa,
                        "Mămăligă cu Ceapă",
                        Categorie.fel_principal,
                        24.5,
                        true,
                        "Mămăligă ca acasă făcută de bunica bucătăreasa",
                        """
        Ingrediente:
        - 1 kg mălai
        - 500 ml lapte
        - 30 g oțet
        - 10 g sare
        - Ceapă prăjită
        
        Vegetarian: Da
        Picant: Nu
        Calorii: 300 kcal
        """
                    )
                )

                lista_items_in_meniu_static.add(
                    Meniu_Item(
                        R.drawable.fish_and_chips,
                        "Fish and Chips",
                        Categorie.fel_principal,
                        26.50,
                        true,
                        "Peste cu cartofi pai",
                        """
        Ingrediente:
        - File de cod (200g)
        - Făină
        - Bere (pentru aluat)
        - Cartofi (300g)
        - Ulei pentru prăjit
        
        Vegetarian: Nu
        Picant: Nu
        Calorii: 600 kcal
        """
                    )
                )

                lista_items_in_meniu_static.add(
                    Meniu_Item(
                        R.drawable.paste_carbonara,
                        "Paste Carbonara",
                        Categorie.fel_principal,
                        27.70,
                        true,
                        "Paste cu cașcaval și carne de porc",
                        """
        Ingrediente:
        - Spaghete (200g)
        - Ouă
        - Guanciale (100g)
        - Pecorino Romano
        - Parmezan
        - Piper negru
        
        Vegetarian: Nu
        Picant: Nu
        Calorii: 550 kcal
        """
                    )
                )


                lista_items_in_meniu_static.add(
                    Meniu_Item(
                        R.drawable.aripioare_de_pui,
                        "Aripioare de pui",
                        Categorie.aperitiv,
                        27.50,
                        true,
                        "Aripioare cu pesmet",
                        """
        Ingrediente:
        - Aripioare de pui (500g)
        - Pesmet
        - Făină
        - Ouă
        - Condimente
        
        Vegetarian: Nu
        Picant: Opțional
        Calorii: 350 kcal
        """
                    )
                )


                lista_items_in_meniu_static.add(
                    Meniu_Item(
                        R.drawable.apa_plata,
                        "Apă Plată",
                        Categorie.nespirtoase,
                        8.00,
                        true,
                        "Apă naturală plată de izvor",
                        """
        Ingrediente:
        - Apă minerală naturală plată (500ml)
        
        Vegetarian: Da
        Picant: Nu
        Calorii: 0 kcal
        Mineralizare: slab mineralizată
        Sursă: Izvorul Minunilor, România
        """
                    )
                )

                lista_items_in_meniu_static.add(
                    Meniu_Item(
                        R.drawable.apa_minerala,
                        "Apă Minerală",
                        Categorie.nespirtoase,
                        8.00,
                        true,
                        "Apă minerală carbogazoasă",
                        """
        Ingrediente:
        - Apă minerală carbogazoasă (500ml)
        - Dioxid de carbon
        
        Vegetarian: Da
        Picant: Nu
        Calorii: 0 kcal
        Mineralizare: medie
        Sursă: Izvorul Zăganu, România
        """
                    )
                )

            }
            SaveAsJson(
                context,
                File_Salvate.Lista_Meniu.toString(),
                lista_items_in_meniu_static
            )

            if(GlobalVars.lista_Angajati.isEmpty()){
                GlobalVars.lista_Angajati.apply {
                    add(Angajat("Andrei","a"))
                    add(Angajat("Admin","Password"))
                    add(Angajat("A","a"))
                }
            }
            SaveAsJson(
                context,
                File_Salvate.Lista_Angajati.toString(),
                GlobalVars.lista_Angajati
            )

        }

        @Throws(IndexOutOfBoundsException::class)
        fun scoateChitanta(context: Context, comanda: Comanda)  {
            var lista_iteme_nume = comanda.list.map { p->p.name }
            var lista_preturi = comanda.list.map{ p->p.price }

            try{
                val string = StringBuilder("Chitanta comanda "+comanda.id+"\n\n")

                var total = 0f

                lista_iteme_nume.forEachIndexed {index,it->
                    string.append(it+"\t\t"+lista_preturi[index].toString()+" lei\n")
                    string.append("x"+comanda.listNumberOfs[index].toString()+"\n\n")

                    total+=(comanda.listNumberOfs[index] * lista_preturi[index]).toFloat()
                }

                string.append("\n\n\nTotal: ${total} lei")

                chitante_lista_ughhhh = LoadFromJson(context, File_Salvate.Chitante_Lista.name,ArrayList<String>())

                chitante_lista_ughhhh.add(comanda.id)
                
                SaveAsJson(context,File_Salvate.Chitante_Lista.name,chitante_lista_ughhhh)

                saveAsTextFile(context,comanda.id.toString(),string.toString(),File(context.filesDir,"Chitante"))

            }catch (ex: IndexOutOfBoundsException){
                throw ex
            }
        }

    }

}
