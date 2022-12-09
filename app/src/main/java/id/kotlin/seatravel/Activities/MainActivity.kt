package id.kotlin.seatravel.Activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import id.kotlin.seatravel.R

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed({
            startActivity(Intent(this, Login::class.java))
            finish()
        } , 3000)

    }
}