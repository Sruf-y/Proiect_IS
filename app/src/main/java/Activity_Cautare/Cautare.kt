package Activity_Cautare





import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.ProiectSI.R;
import java.util.ArrayList;
import Adaptors.Adaptor_Lista;
import Adaptors.Tip_Adaptor
import DataClasses.Categorie
import DataClasses.Meniu_Item;
import DataClasses.GlobalVars.lista_items_in_meniu_static
import Functii_Utils.Functii.Companion.CustomSnack

import android.content.Context
import android.content.Intent
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.ProiectSI.AddItemsToCos
import kotlinx.coroutines.stream.consumeAsFlow


class Cautare : AppCompatActivity(), Adaptor_Lista.onClickListener, Adaptor_Lista.onLongPressListener {
    lateinit var context:Context
    lateinit var recycler:RecyclerView
    lateinit var adaptor: Adaptor_Lista<Meniu_Item>
     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_cautare)

         val finish_activity_button:ImageView = findViewById(R.id.finish_activity_button);

         finish_activity_button.setOnClickListener{
                 finish();
         }

         initializeRecycler()

         val searchview: SearchView = findViewById(R.id.searchView)

         searchview.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
             override fun onQueryTextSubmit(line: String?): Boolean {
                 return true
             }

             override fun onQueryTextChange(line: String): Boolean {
                 if(!line.isEmpty()){
                     adaptor.mlist.clear()


                     for(mancare in lista_items_in_meniu_static){
                         if(mancare.name.lowercase().contains(line.lowercase().trim())){
                             adaptor.mlist.add(mancare)
                         }
                     }

                     recycler.adapter?.notifyDataSetChanged()


                 }
                 else{
                     adaptor.mlist.clear()
                     adaptor.mlist.addAll(lista_items_in_meniu_static)
                     recycler.adapter?.notifyDataSetChanged()
                 }


                 return true
             }

         })



     }

    override fun oncardClick(position: Int,itemviewholder: RecyclerView.ViewHolder) {
        val intent = Intent(context, AddItemsToCos::class.java)
        intent.putExtra("item",adaptor.mlist[position])
        intent.putExtra("itemNr",0)
        startActivity(intent)
    }

    override fun onCardLongPress(position: Int,itemviewholder: RecyclerView.ViewHolder) {
        CustomSnack(
            whereToShowIt = itemviewholder.itemView,
            message = adaptor.mlist[position].nutritionDescription,
        )
    }

    fun initializeRecycler(){

        val lista_fara_unavailable= lista_items_in_meniu_static.filter { p-> p.isAvailable } as ArrayList<Meniu_Item>


        context = this
        recycler = findViewById(R.id.recyclerViewCautare);
        recycler.layoutManager=LinearLayoutManager(context);
        adaptor=Adaptor_Lista(Tip_Adaptor.meniu,lista_fara_unavailable,context,this,this)
        recycler.adapter = adaptor
        //adaptor.updateList(lista_fara_unavailable)
        adaptor.notifyDataSetChanged()
    }

    override fun onResume() {
        super.onResume()
        initializeRecycler()
    }
}