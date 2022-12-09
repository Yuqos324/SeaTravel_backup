package id.kotlin.seatravel.Activities


import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import id.kotlin.seatravel.R
import id.kotlin.seatravel.fragments.home_frag
import id.kotlin.seatravel.fragments.pesan_frag
import id.kotlin.seatravel.helper.PrefHelper


class Home : AppCompatActivity() {

    private lateinit var    navController: NavController

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        replaceFragment(pesan_frag())

        val navHostFragement = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        navController = navHostFragement.navController
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        setupWithNavController(bottomNavigationView, navController)

    }

    private fun replaceFragment(pesanFrag: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.constraintLayout,pesanFrag)
        fragmentTransaction.commit()

    }


}