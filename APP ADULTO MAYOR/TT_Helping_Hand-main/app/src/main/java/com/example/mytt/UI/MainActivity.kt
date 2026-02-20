package com.example.mytt.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.mytt.R
import com.example.mytt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Emergencies())

        binding.btNavigation.setOnItemReselectedListener {

            when(it.itemId){
                R.id.nav_emergencies -> replaceFragment(Emergencies())
                R.id.nav_calendar -> replaceFragment(Calendar())
                R.id.nav_info -> replaceFragment(Information())
                R.id.nav_medicine -> replaceFragment(Medicines())
                R.id.nav_profile -> replaceFragment(Profile())

                else -> {

                }
            }
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}