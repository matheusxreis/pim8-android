package com.matheuxreis.pim8

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment(SignIn())
        bottomNavListener()
    }


    fun bottomNavListener(){
        val authNavBottom = findViewById<NavigationBarView>(R.id.auth_bottom_navigation);
        authNavBottom.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.auth_page_1 -> {
                    loadFragment(SignIn())
                    return@setOnItemSelectedListener true

                }
                R.id.auth_page_2 -> {
                    loadFragment(SignUp2())
                    return@setOnItemSelectedListener true
                }
                else -> {
                    return@setOnItemSelectedListener false

                }
            }
        }
    }

    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
   }




