package Activity_Cautare





import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.ProiectSI.R;
import java.util.ArrayList;
import Adaptors.MeniuAdaptor_Lista;
import DataClasses.Meniu_Item;
import Start_Activity.GlobalVars
import Start_Activity.GlobalVars.lista_items_in_meniu_static

import android.content.Context
import android.widget.SearchView
import androidx.activity.contextaware.ContextAware
import androidx.recyclerview.widget.LinearLayoutManager


class Cautare : AppCompatActivity(), MeniuAdaptor_Lista.onClickListener, MeniuAdaptor_Lista.onLongPressListener {

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_cautare)

         val finish_activity_button:ImageView = findViewById(R.id.finish_activity_button);

         finish_activity_button.setOnClickListener{
                 finish();
         }


         // recycler adaptor
         val display_list=ArrayList<Meniu_Item>()
         display_list.addAll(lista_items_in_meniu_static)
         val recycler:RecyclerView = findViewById(R.id.recyclerViewCautare);
         val adaptor= MeniuAdaptor_Lista(display_list,this,this)
         recycler.layoutManager=LinearLayoutManager(this);
         recycler.adapter=adaptor
         recycler.adapter?.notifyDataSetChanged()
         val context: Context = this

         val searchview: SearchView = findViewById(R.id.searchView)

         searchview.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
             override fun onQueryTextSubmit(line: String?): Boolean {
                 return true
             }

             override fun onQueryTextChange(line: String): Boolean {
                 if(!line.isEmpty()){
                     display_list.clear()

                     val searched_line= line.lowercase()

                     for(mancare in lista_items_in_meniu_static){
                         if(mancare.name.lowercase().contains(line.lowercase().trim())){
                             display_list.add(mancare)
                         }
                     }
                     //reset adapter for some reason, ugh
                     recycler.adapter=MeniuAdaptor_Lista(display_list,
                         context as MeniuAdaptor_Lista.onClickListener, context as MeniuAdaptor_Lista.onLongPressListener
                     )
                     recycler.adapter?.notifyDataSetChanged()


                 }
                 else{
                     display_list.clear()
                     display_list.addAll(lista_items_in_meniu_static)
                     recycler.adapter?.notifyDataSetChanged()
                 }


                 return true
             }

         })



     }

    override fun oncardClick(position: Int,itemviewholder: RecyclerView.ViewHolder) {
        TODO("Not yet implemented")
    }

    override fun onCardLongPress(position: Int,itemviewholder: RecyclerView.ViewHolder) {
        TODO("Not yet implemented")
    }

    override fun onResume() {
        super.onResume()
        val recycler:RecyclerView = findViewById(R.id.recyclerViewCautare)

        recycler.layoutManager=LinearLayoutManager(this);



        val adaptor= MeniuAdaptor_Lista(lista_items_in_meniu_static,this,this);

        recycler.adapter=adaptor
        recycler.adapter?.notifyDataSetChanged()
    }
}