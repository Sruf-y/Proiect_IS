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
 * Use the {@link BauturiNespirtoase#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BauturiNespirtoase extends Fragment {


    public BauturiNespirtoase() {
        // Required empty public constructor
    }


    public static BauturiNespirtoase newInstance(String param1, String param2) {
        BauturiNespirtoase fragment = new BauturiNespirtoase();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

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
}