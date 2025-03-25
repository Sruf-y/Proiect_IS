package Functii_Utils

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File

class Functii {

    companion object {
        fun <T> SaveAsJson(context: Context, filename: String, data: T) {
            val json = Gson().toJson(data);
            val filepath = context.filesDir.toString() + "/" + filename + ".json"

            File(filepath).writeText(json)
        }
        //exemplu utilizare in java


        // Functii.Companion.SaveAsJson(Adaugare_Mancare.this,"Lista_Meniu",GlobalVars.INSTANCE.getLista_items_in_meniu_static());

        fun <T> LoadFromJson(context: Context, filename: String, data: T): T {

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

        //exemplu utilizare in java

        //GlobalVars.INSTANCE.setLista_items_in_meniu_static(Functii.Companion.LoadFromJson(Adaugare_Mancare.this,"Lista_Meniu",GlobalVars.INSTANCE.getLista_items_in_meniu_static()));
    }
}