package com.example.myttcare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.myttcare.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btNavigation.selectedItemId = R.id.nav_alerts

        replaceFragment(Alerts())
        binding.btNavigation.setOnItemSelectedListener {

            when(it.itemId){
                R.id.nav_alerts -> replaceFragment(Alerts())
                R.id.nav_users -> replaceFragment(Users())
                R.id.nav_profile -> replaceFragment(Profile())

                else -> { }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}