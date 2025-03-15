package com.ProiectSI

import DataClasses.Angajat
import Start_Activity.AdminActivity
import Start_Activity.AngajatActivity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.log


val Lista_Angajati = ArrayList<Angajat>();

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

        val username:EditText = findViewById(R.id.usernameEditText)

        val password:EditText = findViewById(R.id.passwordEditText)

        val loginbuton: Button = findViewById(R.id.Log_In_Button)

        val admin_username:String = "admin@restaurant.null"
        val admin_password:String = "adminRestaurantMagic12"

        Lista_Angajati.add(Angajat("Andrei","Botofan"))

        loginbuton.setOnClickListener{
            if(username.text.toString()==admin_username && password.text.toString()==admin_password)
            {
                val intent = Intent(this,AdminActivity::class.java)
                startActivity(intent)
            }
            else if(Lista_Angajati.size>0)
            {
                for(i in Lista_Angajati)
                    if(i.username==username.text.toString() && i.password==password.text.toString())
                    {
                        val intent = Intent(this,AngajatActivity::class.java)
                        intent.putExtra("arg1",username.text.toString())
                        intent.putExtra("arg2",password.text.toString())
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
        val username:EditText = findViewById(R.id.usernameEditText)

        val password:EditText = findViewById(R.id.passwordEditText)

        username.text.clear()
        password.text.clear()
    }
}

fun customToast(whereToShowIt: View, context: Context, message: String) {
    val tost = Toast.makeText(context, message, Toast.LENGTH_SHORT);


    tost.show();
}