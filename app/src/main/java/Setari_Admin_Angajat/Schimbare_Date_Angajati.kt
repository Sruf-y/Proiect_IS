package Setari_Admin_Angajat

import Adaptors.Angajat_Adaptor
import DataClasses.Angajat
import DataClasses.GlobalVars
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ProiectSI.R

class Schimbare_Date_Angajati : AppCompatActivity() {

    private lateinit var recycler: RecyclerView
    private lateinit var adaptor: Angajat_Adaptor
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_schimbare_date_angajati)

        setupWindowInsets()
        setupRecyclerView()
    }

    private fun setupWindowInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }
    }

    private fun setupRecyclerView() {
        recycler = findViewById(R.id.recycler)

        adaptor = Angajat_Adaptor(
            onClick = { angajat ->
                openEditAngajatActivity(angajat)
            },
            onLongClick = { angajat ->
                removeAngajat(angajat)
            }
        )

        layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        recycler.apply {
            adapter = adaptor
            layoutManager = this@Schimbare_Date_Angajati.layoutManager
            setHasFixedSize(true) // Improves performance if item size is fixed
        }
    }

    private fun openEditAngajatActivity(angajat: Angajat) {
        Intent(this, Creare_Cont_Angajat::class.java).apply {
            putExtra("ang", angajat) // Or pass the whole object if needed
            startActivity(this)
        }
    }

    private fun removeAngajat(angajat: Angajat) {
        GlobalVars.lista_Angajati?.remove(angajat)
        adaptor.notifyDataSetChanged()
    }

    override fun onResume() {
        super.onResume()
        adaptor.notifyDataSetChanged() // Refresh data when returning from edit
    }
}