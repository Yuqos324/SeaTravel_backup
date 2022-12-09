package id.kotlin.seatravel.Activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import id.kotlin.seatravel.R
import id.kotlin.seatravel.helper.Constant
import id.kotlin.seatravel.helper.PrefHelper

class Login : AppCompatActivity() {

    lateinit var button : Button
    lateinit var username : EditText
    lateinit var password : EditText
    lateinit var sharedPref : PrefHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        button = findViewById(R.id.loginBtn)
        username = findViewById(R.id.usernameEditText)
        password = findViewById(R.id.passwordEditText)

        sharedPref = PrefHelper(this)

        val sharedPreference =  getSharedPreferences(
            "app_preference", Context.MODE_PRIVATE
        )

        val intent = Intent(this, Home::class.java)

        button.setOnClickListener{
            if (username.text.isNotEmpty() && password.text.isNotEmpty()){
                sharedPref.put( Constant.PREF_USERNAME, username.toString() )
                sharedPref.put( Constant.PREF_PASSWORD, password.toString() )
                sharedPref.put( Constant.PREF_IS_LOGIN, true)
                Toast.makeText(
                    applicationContext,
                    "Berhasil login",
                    Toast.LENGTH_SHORT
                ).show()
                moveIntent()
            }else{
                Toast.makeText(
                    applicationContext,
                    "Harap isi kolom yang kosong terlebih dahulu",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
        }

    }

    private fun moveIntent() {
        startActivity(Intent(this, Home::class.java))
        finish()
    }

    override fun onStart() {
        super.onStart()
        if (sharedPref.getBoolean(Constant.PREF_IS_LOGIN)){
            moveIntent()
        }
    }
}