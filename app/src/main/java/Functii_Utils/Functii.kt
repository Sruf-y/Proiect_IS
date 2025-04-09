package Functii_Utils

import DataClasses.Categorie
import DataClasses.GlobalVars
import DataClasses.GlobalVars.lista_items_in_meniu_static
import DataClasses.Meniu_Item
import Start_Activity.File_Salvate
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBar
import androidx.core.content.ContextCompat
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
                    context.openFileOutput("$filename.txt", Context.MODE_PRIVATE);
                fos.write(message.toByteArray());
                fos.close();
            } catch (e: IOException) {
                e.printStackTrace();
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
                    width = ActionBar.LayoutParams.WRAP_CONTENT;
                    gravity = Gravity.END or Gravity.BOTTOM;
                }

                view.apply {
                    setBackgroundColor(ContextCompat.getColor(context, R.color.gray))

                    setAnchorView(whereToShowIt)

                }
            }.show()
        }


        fun <T> SaveAsJson(context: Context, filename: String, data: T) {
            val json = Gson().toJson(data);
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
                    FileInputStream(context.filesDir.toString() + "/" + filename + ".json");
                val ois: ObjectInputStream = ObjectInputStream(f);
                val o: Object = ois.readObject() as Object
                ois.close();
                f.close();
                return o as T;
            } catch (e: Exception) {
                e.printStackTrace();
            }
            return data;
        }


        fun CheckNewInstallLoadList(context: Context) {

            if (lista_items_in_meniu_static.isEmpty()) {

                lista_items_in_meniu_static.add(
                    Meniu_Item(
                        -1,
                        "Mamaliguta Cu Ceapa",
                        Categorie.fel_principal,
                        24.5,
                        true,
                        "Mamaliga ca acasa facuta de bunica bucatareasa.",
                        "30g otet \n10g sare \n500ml lapte \n1kgmalai"
                    )
                )
                lista_items_in_meniu_static.add(
                    Meniu_Item(
                        -1,
                        "mancare de rata",
                        Categorie.spirtoase,
                        295.3,
                        false,
                        "",
                        ""

                    )
                )
                lista_items_in_meniu_static.add(
                    Meniu_Item(
                        -1,
                        "Fish and Chips",
                        Categorie.fel_principal,
                        26.50,
                        true,
                        "peste cu cartofi pai",
                        "Valori nutriționale : Calorii: 600 kcal"

                    )
                )
                lista_items_in_meniu_static.add(
                    Meniu_Item(
                        -1,
                        "Paste Carbonara",
                        Categorie.fel_principal,
                        27.70,
                        true,
                        "paste cu cascaval si carne de porc",
                        "Valori nutritionale: 163.85 Kcal"
                    )
                )
                lista_items_in_meniu_static.add(
                    Meniu_Item(
                        -1,
                        "Pizza Taraneasca",
                        Categorie.fel_principal,
                        57.80,
                        true,
                        "pizza cu legume si sunca",
                        "Valori nutritionale:312 Kcal"
                    )
                )

                lista_items_in_meniu_static.add(
                    Meniu_Item(
                        -1,
                        "Aripioare de pui picante/nepicante",
                        Categorie.aperitiv,
                        27.50,
                        true,
                        "aripioare cu pesmet",
                        "Valori nutritionale:203 Kcal"
                    )
                )
                lista_items_in_meniu_static.add(
                    Meniu_Item(
                        -1,
                        "Limonada",
                        Categorie.nespirtoase,
                        14.40,
                        true,
                        "bautura din zeama de lamaie",
                        "Valori nutritionale:40.2 Kcal"
                    )
                )
                lista_items_in_meniu_static.add(
                    Meniu_Item(
                        -1,
                        "Mojito",
                        Categorie.spirtoase,
                        23.20,
                        true,
                        "cocktail",
                        "Valori nutritionale: 214 Kcal"
                    )
                )
                lista_items_in_meniu_static.add(
                    Meniu_Item(
                        -1,
                        "Whisky",
                        Categorie.spirtoase,
                        22.00,
                        true,
                        "Bautura alcoolica",
                        "Valori Nutritionale:250 Kcal"

                    )
                )
                lista_items_in_meniu_static.add(
                    Meniu_Item(
                        -1,
                        "Fresh de Portocale",
                        Categorie.nespirtoase,
                        15.59,
                        true,
                        "bautura din portocale stoarse",
                        "Valori Nutritionale:79Kcal"
                    )
                )
                lista_items_in_meniu_static.add(
                    Meniu_Item(
                        -1,
                        "Ciorba de perisoare",
                        Categorie.fel_principal,
                        13.50,
                        true,
                        "Ciorba tipica romaneasca",
                        "Valori nutritionale:47.28"
                    )
                )
                lista_items_in_meniu_static.add(
                    Meniu_Item(
                        -1,
                        "Hot Dog",
                        Categorie.fel_principal,
                        8.50,
                        true,
                        "Hot Dog cu cabanosi",
                        "Valori Nutririonale:289 Kcal"
                    )
                )
                lista_items_in_meniu_static.add(
                    Meniu_Item(
                        -1,
                        "Mici",
                        Categorie.aperitiv,
                        14.50,
                        true,
                        "Un fel de chiftele la gratar",
                        "Valori Nutritionale: 178 Kcal"
                    )
                )
                lista_items_in_meniu_static.add(
                    Meniu_Item(
                        -1,
                        "Salata de Varza",
                        Categorie.aperitiv,
                        4.00,
                        true,
                        "Varza curda tocata",
                        "Valori Nutritionale:152.5 Kcal"
                    )
                )
                lista_items_in_meniu_static.add(
                    Meniu_Item(
                        -1,
                        "Gulas",
                        Categorie.fel_principal,
                        30.00,
                        true,
                        "tocana de carne si legume",
                        "Valori Nutritionale:250Kcal"
                    )
                )
                lista_items_in_meniu_static.add(
                    Meniu_Item(
                        -1,
                        "Ceafa de Porc ",
                        Categorie.aperitiv,
                        15.90,
                        true,
                        "ceafa de porc gatita la gratar",
                        "Valori Nutritionale:250.5 Kcal"
                    )
                )
                lista_items_in_meniu_static.add(
                    Meniu_Item(
                        -1,
                        "Pulpe la gratar cu legume",
                        Categorie.fel_principal,
                        49.50,
                        true,
                        "pulpe si legume proaspete",
                        "Valori Nutritionale: 239 Kcal"
                    )
                )
                lista_items_in_meniu_static.add(
                    Meniu_Item(
                        -1,
                        "Pilaf de orez",
                        Categorie.aperitiv,
                        7.30,
                        true,
                        "Orez din grau",
                        "Valori Nutritionale: 359 Kcal"
                    )
                )
                lista_items_in_meniu_static.add(
                    Meniu_Item(
                        -1,
                        "Mazare",
                        Categorie.aperitiv,
                        6.30,
                        true,
                        "Mazare cu sare si piper",
                        "Valori Nutritionale:81Kcal"
                    )
                )
                lista_items_in_meniu_static.add(
                    Meniu_Item(
                        -1,
                        "Ardei Umbluti",
                        Categorie.fel_principal,
                        8.40,
                        true,
                        "Ardei umbluti cu carne,legume,orez",
                        "Valori Nutritionale:30.7 Kcal"
                    )
                )
                lista_items_in_meniu_static.add(
                    Meniu_Item(
                        -1,
                        "Halva",
                        Categorie.aperitiv,
                        14.35,
                        true,
                        "Specialitate de cofetarie, originara din India",
                        "Valori Nutritionale:468.9 Kcal"
                    )
                )
                lista_items_in_meniu_static.add(
                    Meniu_Item(
                        -1,
                        "Clatite",
                        Categorie.aperitiv,
                        30.00,
                        true,
                        "Preparat culinar obtinut prin coacerea unei foi subtiri",
                        "Valori Nutritionale:196.16 Kcal"

                    )
                )
                lista_items_in_meniu_static.add(
                    Meniu_Item(
                        -1,
                        "Burger",
                        Categorie.fel_principal,
                        25.60,
                        true,
                        "mancare servita rapid",
                        "Valori Nutritionale:294.9 Kcal"
                    )
                )
                lista_items_in_meniu_static.add(
                    Meniu_Item(
                        -1,
                        "Placinta cu Branza",
                        Categorie.aperitiv,
                        19.99,
                        true,
                        "Preparat din Grecia Antica si Roma",
                        "Valori Nutritionale: 164.18 Kcal"
                    )
                )
                lista_items_in_meniu_static.add(
                    Meniu_Item(
                        -1,
                        "Carnati",
                        Categorie.aperitiv,
                        25.00,
                        true,
                        "Aliment din carne tocata, slanina, sare, condimente",
                        "Valori Nutritionale: 300.9 Kcal"
                    )
                )
                lista_items_in_meniu_static.add(
                    Meniu_Item(
                        -1,
                        "Frigarui",
                        Categorie.aperitiv,
                        20.00,
                        true,
                        "Mancare romaneasca ce consta in bucati  mici de carne sau legume",
                        "Valori Nutritionale: 114.97"
                    )
                )
                lista_items_in_meniu_static.add(
                    Meniu_Item(
                        -1,
                        "Mamaliga",
                        Categorie.aperitiv,
                        18.00,
                        true,
                        "Preparat din faina de porumb",
                        "Valori Nutritionale: 70 Kcal"
                    )
                )
                lista_items_in_meniu_static.add(
                    Meniu_Item(
                        -1,
                        "Bere",
                        Categorie.spirtoase,
                        30.00,
                        true,
                        "Bautura alcoolica",
                        "Valori Nutritionale:43.3 Kcal"
                    )
                )
                lista_items_in_meniu_static.add(
                    Meniu_Item(
                        -1,
                        "Vin",
                        Categorie.spirtoase,
                        58.00,
                        true,
                        "Bautura alcoolica obtinuta prin fermentarea strugurilor",
                        "Valori Nutritionale: 82.9 Kcal"
                    )
                )

            }


            SaveAsJson(
                context,
                File_Salvate.Lista_Meniu.toString(),
                GlobalVars.lista_items_in_meniu_static
            )
        }
    }

}
