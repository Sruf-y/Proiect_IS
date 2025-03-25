package FragmentMeniu


import Activity_Cautare.Cautare
import Adaptors.TabSwipeAdaptor
import DataClasses.Meniu_Item
import Start_Activity.StartActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.ProiectSI.Login_Activity
import com.ProiectSI.R
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class FragmentMeniu : Fragment(R.layout.fragment_meniu) {





    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // aici se scrie codul intr-un fragment

        val pagesView: ViewPager2 = requireView().findViewById(R.id.tabHolder)
        val tabs : TabLayout = requireView().findViewById(R.id.tabLayout)


        pagesView.adapter = TabSwipeAdaptor(this)

        // ataseaza tabs de adaptorul de fragmente pentru a fi up-to-date
        TabLayoutMediator(tabs,pagesView){tab,position->
            when(position){
                0->tab.text="Aperitive"
                1->tab.text="Fel Principal"
                2->tab.text="Bauturi spirtoase"
                3->tab.text="Bauturi nespirtoase"
            }
        }.attach()


        val auth_buton: ImageView = requireView().findViewById(R.id.login_button2)
        auth_buton.setOnClickListener{
            val intent = Intent(requireContext(), Login_Activity::class.java)
            startActivity(intent)
        }


        val search_button: ImageView = requireView().findViewById(R.id.search_button)

        search_button.setOnClickListener {
            val intent = Intent(requireContext(), Cautare::class.java)

            startActivity(intent)
        }


    }

}