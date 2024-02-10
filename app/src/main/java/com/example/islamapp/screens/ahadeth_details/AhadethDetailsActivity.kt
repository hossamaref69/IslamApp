package com.example.islamapp.screens.ahadeth_details

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.islamapp.databinding.ActivityAhadethDetailsBinding
import com.example.islamapp.model.HadeethModel

class AhadethDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityAhadethDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAhadethDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val hadeth = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra(com.example.islamapp.constants.Constants.HADETH, HadeethModel::class.java)
        } else {
            intent.getSerializableExtra(com.example.islamapp.constants.Constants.HADETH) as HadeethModel
        }

        binding.hadethContentTv.text = hadeth!!.content
        binding.hadethNameTv.text = hadeth.title
    }
}