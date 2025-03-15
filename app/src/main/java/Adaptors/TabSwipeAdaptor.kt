package Adaptors

import TabsMeniu.Aperitive
import TabsMeniu.BauturiNespirtoase
import TabsMeniu.BauturiSpirtoase
import TabsMeniu.FeluriPrincipale
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabSwipeAdaptor(fragment: Fragment): FragmentStateAdapter(fragment) {


    override fun getItemCount(): Int {
        return 4;
    }


    override fun createFragment(position: Int): Fragment {



        return when(position){
            0-> Aperitive() // MusicFragment();
            1-> FeluriPrincipale();
            2-> BauturiSpirtoase() //LyricsFragment();
            3->BauturiNespirtoase()
            else-> Aperitive();
        }


    }

}