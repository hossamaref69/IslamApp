package com.example.islamapp.screens.home.fragments.ahadeth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islamapp.constants.Constants
import com.example.islamapp.model.HadeethModel
import com.example.islamapp.databinding.FragmentAhadethBinding
import com.example.islamapp.screens.ahadeth_details.AhadethDetailsActivity
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class AhadethFragment : Fragment() {
    lateinit var binding:FragmentAhadethBinding
    var ahadeth = ArrayList<HadeethModel>()
    lateinit var adapter: AhadethAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentAhadethBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readAhadeth()
        adapter = AhadethAdapter(ahadeth)
        adapter.onHadethClick = object: AhadethAdapter.OnItemClickListener {
            override fun onItemClick(hadeth: HadeethModel, index: Int) {
                val intent = Intent(activity, AhadethDetailsActivity::class.java)
                intent.putExtra(Constants.HADETH, hadeth)
                startActivity(intent)
            }
        }
        binding.ahadethNameRecyclerView.adapter = adapter
    }

    private fun readAhadeth(){
        try {
            val inputStream = requireActivity().assets.open("ahadeeth.txt")
            val reader = BufferedReader(InputStreamReader(inputStream))
            val hadethFileContent = reader.readText()
            val ahadethList: List<String> = hadethFileContent.split("#")
            for(hadeth: String in ahadethList){
                val singleHadethWithSpaces = hadeth.trim()
                val singleHadethLine:MutableList<String> = singleHadethWithSpaces.split("\n").toMutableList()
                val hadethTitle = singleHadethLine[0]
                singleHadethLine.removeAt(0)
                val content = singleHadethLine.joinToString(separator = " "){
                    return@joinToString it
                }
                ahadeth.add(HadeethModel(hadethTitle, content))

            }
                inputStream.close()
            } catch (e: IOException) {
            e.printStackTrace()
        }
 }
}