package TabsMeniu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ProiectSI.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FeluriPrincipale#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FeluriPrincipale extends Fragment {


    public FeluriPrincipale() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feluri_principale, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        // scrie codul aici
    }
}