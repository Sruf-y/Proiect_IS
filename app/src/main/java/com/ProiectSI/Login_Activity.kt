package com.ProiectSI

import DataClasses.Angajat
import DataClasses.GlobalVars
import Start_Activity.AdminActivity
import DataClasses.GlobalVars.lista_Angajati
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.log


class Login_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_login)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        val username:EditText = findViewById(R.id.Email)

        val password:EditText = findViewById(R.id.passwordEditText)

        val loginbuton: Button = findViewById(R.id.Log_In_Button)

        val admin_username:String = "admin@restaurant.null"
        val admin_password:String = "adminRestaurantMagic12"

        // normal mode
        if(!GlobalVars.APP_IN_TEST_MODE) {
            loginbuton.setOnClickListener {
                if (username.text.toString() == admin_username && password.text.toString() == admin_password) {
                    val intent = Intent(this, AdminActivity::class.java)
                    intent.putExtra("arg1", "admin@restaurant.null")
                    intent.putExtra("arg2", "adminRestaurantMagic12")
                    intent.putExtra("arg3", "admin");
                    startActivity(intent)
                } else {
                    for (i in lista_Angajati) {
                        if (i.username == username.text.toString() && i.password == password.text.toString()) {

                            Toast.makeText(this, "Combinatie incorecta!", Toast.LENGTH_SHORT).show()

                            val intent = Intent(this, AdminActivity::class.java)
                            intent.putExtra("arg1", username.text.toString())
                            intent.putExtra("arg2", password.text.toString())
                            intent.putExtra("arg3", "angajat");
                            startActivity(intent)
                            break;
                        }
                    }

                }
            }
        }
        else {
            loginbuton.setOnClickListener {
                val intent = Intent(this, AdminActivity::class.java)
                intent.putExtra("arg1", "admin@restaurant.null")
                intent.putExtra("arg2", "adminRestaurantMagic12")
                intent.putExtra("arg3", "admin");
                startActivity(intent)
            }
        }





    }

    override fun onResume() {
        super.onResume()
        val username:EditText = findViewById(R.id.Email)

        val password:EditText = findViewById(R.id.passwordEditText)

        username.text.clear()
        password.text.clear()
    }
}

