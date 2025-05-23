package TabsMeniu;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ProiectSI.AddItemsToCos;
import com.ProiectSI.R;

import org.jetbrains.annotations.NotNull;

import Adaptors.Adaptor_Lista;
import Adaptors.Tip_Adaptor;
import DataClasses.Categorie;
import DataClasses.GlobalVars;
import DataClasses.Meniu_Item;
import Functii_Utils.Functii;


public class Aperitive extends Fragment implements Adaptor_Lista.onClickListener,Adaptor_Lista.onLongPressListener {


    public Aperitive() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_aperitive, container, false);
    }

    Adaptor_Lista<Meniu_Item> adaptor;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        adaptor = new Adaptor_Lista(Tip_Adaptor.meniu, GlobalVars.INSTANCE.getLista_items_in_meniu_static(),requireContext(),this,this, Categorie.aperitiv,null);

        // Definirea RecyclerView din layout
        RecyclerView recyclerView = requireView().findViewById(R.id.recycler);

        // Setarea LinearLayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false));

        // Setarea adapter-ului
        recyclerView.setAdapter(adaptor);

        // Notificarea schimbărilor
        recyclerView.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void oncardClick(int position, RecyclerView.@NotNull ViewHolder itemviewholder) {

        var intent = new Intent(requireContext(), AddItemsToCos.class);
        intent.putExtra("item",adaptor.getMlist().get(position));
        intent.putExtra("itemNr",0);
        startActivity(intent);

    }

    @Override
    public void onCardLongPress(int position, RecyclerView.@NotNull ViewHolder itemviewholder) {

        Functii.Companion.CustomSnack( itemviewholder.itemView, adaptor.getMlist().get(position).getNutritionDescription());
    }

    @Override
    public void onResume() {
        super.onResume();

        adaptor.updateList(GlobalVars.INSTANCE.getLista_items_in_meniu_static());
    }

}