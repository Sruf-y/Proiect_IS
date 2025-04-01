package Activity_Cautare





import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.ProiectSI.R;
import java.util.ArrayList;
import Adaptors.Adaptor_Lista;
import Adaptors.Tip_Adaptor
import DataClasses.Meniu_Item;
import DataClasses.GlobalVars.lista_items_in_meniu_static

import android.content.Context
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager


class Cautare : AppCompatActivity(), Adaptor_Lista.onClickListener, Adaptor_Lista.onLongPressListener {

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
         val adaptor= Adaptor_Lista(Tip_Adaptor.meniu,display_list,this,this)
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
                     recycler.adapter=Adaptor_Lista(Tip_Adaptor.meniu,display_list,
                         context as Adaptor_Lista.onClickListener, context as Adaptor_Lista.onLongPressListener
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



        val adaptor= Adaptor_Lista(Tip_Adaptor.meniu,lista_items_in_meniu_static,this,this);

        recycler.adapter=adaptor
        recycler.adapter?.notifyDataSetChanged()
    }
}