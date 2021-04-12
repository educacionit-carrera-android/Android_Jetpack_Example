package com.example.androidjetpackexample.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidjetpackexample.R
import com.example.androidjetpackexample.ui.fragments.LibrosFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if (savedInstanceState == null) {
            navigateToLibros()
        }
    }

    private fun navigateToLibros() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, LibrosFragment(), LibrosFragment::class.simpleName)
            .commit()
    }
}