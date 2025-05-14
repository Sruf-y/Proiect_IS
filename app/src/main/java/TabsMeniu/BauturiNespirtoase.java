package TabsMeniu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ProiectSI.R;

import org.jetbrains.annotations.NotNull;

import Adaptors.Adaptor_Lista;


public class BauturiNespirtoase extends Fragment implements Adaptor_Lista.onClickListener,Adaptor_Lista.onLongPressListener {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bauturi_nespirtoase, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        // AICI SE SCRIE CODUL
    }

    @Override
    public void oncardClick(int position, RecyclerView.@NotNull ViewHolder itemviewholder) {

    }

    @Override
    public void onCardLongPress(int position, RecyclerView.@NotNull ViewHolder itemviewholder) {

    }
}