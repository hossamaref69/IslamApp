package com.example.islamapp.screens.home.fragments.quran

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islamapp.constants.Constants
import com.example.islamapp.R
import com.example.islamapp.databinding.FragmentQuranBinding
import com.example.islamapp.screens.sura_details.SuraDetailsActivity

class QuranFragment : Fragment() {
    lateinit var binding: FragmentQuranBinding
    lateinit var surasAdapter : SuraNameAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding =  FragmentQuranBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        val stingSurasName= resources.getStringArray(R.array.quran_chapters)
        surasAdapter = SuraNameAdapter(stingSurasName)
        surasAdapter.onSuraClick = object: SuraNameAdapter.OnItemClickListener {
            override fun onItemClick(suraName: String, index: Int) {
                val intent = Intent(activity, SuraDetailsActivity::class.java)
                val fileName = "${index + 1}.txt"
                intent.putExtra(Constants.FILE_NAME,fileName)
                intent.putExtra(Constants.SURA_NAME, suraName)
                startActivity(intent)
            }
        }
        binding.suraNameRecyclerView.adapter = surasAdapter
    }
}


