package Functii_Utils

import DataClasses.GlobalVars
import DataClasses.Meniu_Item
import Start_Activity.File_Salvate
import android.content.Context
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBar
import androidx.core.content.ContextCompat
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

    fun WriteStringInFile(context:Context,filename:String,message:String) {

        try {

            val fos:FileOutputStream = context . openFileOutput ("$filename.txt", Context.MODE_PRIVATE);
            fos.write(message.toByteArray());
            fos.close();
        } catch (e:IOException ) {
            e.printStackTrace();
        }
    }

    fun CustomSnack(whereToShowIt: View, message: String){
        val snack = Snackbar.make(whereToShowIt,message, Snackbar.LENGTH_SHORT)
        snack.animationMode=Snackbar.ANIMATION_MODE_FADE
        snack.apply {
            view.setOnClickListener {
                dismiss()
            }

            behavior=object:BaseTransientBottomBar.Behavior() {
                override fun canSwipeDismissView(child: View): Boolean {
                    return true
                }
            }

            (view.layoutParams as FrameLayout.LayoutParams).apply {
                width= ActionBar.LayoutParams.WRAP_CONTENT;
                gravity= Gravity.END or Gravity.BOTTOM;
            }

            view.apply {
                setBackgroundColor( ContextCompat.getColor(context,R.color.gray))

                setAnchorView(whereToShowIt)

            }
        }.show()
    }


    companion object {
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



        fun<T> LoadFromJson(context:Context,filename:String,data:T):T {


            try {
                val f:FileInputStream =FileInputStream(context.filesDir.toString() + "/" + filename + ".json");
                val ois:ObjectInputStream =ObjectInputStream(f);
                val o:Object= ois.readObject() as Object
                ois.close();
                f.close();
                return o as T;
            }
            catch (e: Exception) {
                e.printStackTrace();
            }
            return data;
        }


        fun CheckNewInstallLoadList(context:Context){
            if(GlobalVars.lista_items_in_meniu_static.isEmpty()){
                GlobalVars.lista_items_in_meniu_static.addAll( Meniu_Item().ParseArrayList(""));
                SaveAsJson(context, File_Salvate.Lista_Meniu.toString(), GlobalVars.lista_items_in_meniu_static)
            }
        }

    }
}