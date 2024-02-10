package com.example.islamapp.screens.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import androidx.fragment.app.Fragment
import com.example.islamapp.R
import com.example.islamapp.databinding.ActivityHomeBinding
import com.example.islamapp.screens.home.fragments.ahadeth.AhadethFragment
import com.example.islamapp.screens.home.fragments.quran.QuranFragment
import com.example.islamapp.screens.home.fragments.radio.RadioFragment
import com.example.islamapp.screens.home.fragments.sebha.SebhaFragment
import com.google.android.material.navigation.NavigationBarView

class HomeActivity : AppCompatActivity() {
    lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startFragment(QuranFragment())
        makeBinding()
        selectedItem()
    }

    private fun selectedItem() {
        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.ic_quran -> {
                    startFragment(QuranFragment())
                }

                R.id.ic_ahadeth -> {
                    startFragment(AhadethFragment())
                }

                R.id.ic_sebha -> {
                    startFragment(SebhaFragment())
                }

                R.id.ic_raido -> {
                    startFragment(RadioFragment())
                }
            }
            return@setOnItemSelectedListener true
        }
    }

    private fun makeBinding(){
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun startFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, fragment)
            .commit()
    }
}