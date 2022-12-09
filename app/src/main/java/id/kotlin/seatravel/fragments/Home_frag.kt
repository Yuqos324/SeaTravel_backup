package id.kotlin.seatravel.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import id.kotlin.seatravel.Activities.Login
import id.kotlin.seatravel.R
import id.kotlin.seatravel.helper.PrefHelper


class home_frag : Fragment() {

    lateinit var btnLogout : ImageButton
    lateinit var sharedPref : PrefHelper


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home_frag, container, false)


        //code logic fragment
        btnLogout = view.findViewById(R.id.logout)

        sharedPref = activity?.let { PrefHelper(it) }!!

        btnLogout.setOnClickListener {
            sharedPref.clear()
            val intent = Intent(activity , Login::class.java)
            startActivity(intent)
        }

        return view

    }


}