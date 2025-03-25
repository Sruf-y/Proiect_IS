package com.ProiectSI

import DataClasses.Angajat
import Start_Activity.AdminActivity
import Start_Activity.Lista_Angajati
import Start_Activity.customToast
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


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

        Lista_Angajati.add(Angajat("Andrei","Botofan"))
        Lista_Angajati.add(Angajat("Bologa","Darius"))

        loginbuton.setOnClickListener{
            if(username.text.toString()==admin_username && password.text.toString()==admin_password)
            {
                val intent = Intent(this,AdminActivity::class.java)
                intent.putExtra("arg1",username.text.toString())
                intent.putExtra("arg2",password.text.toString())
                intent.putExtra("arg3","admin");
                startActivity(intent)
            }
            else if(Lista_Angajati.size>0)
            {
                for(i in Lista_Angajati)
                    if(i.username==username.text.toString() && i.password==password.text.toString())
                    {
                        val intent = Intent(this,AdminActivity::class.java)
                        intent.putExtra("arg1",username.text.toString())
                        intent.putExtra("arg2",password.text.toString())
                        intent.putExtra("arg3","angajat");
                        startActivity(intent)
                        break;
                    }
            }
            else{
                customToast(loginbuton,this,"Incorrect combination")
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

