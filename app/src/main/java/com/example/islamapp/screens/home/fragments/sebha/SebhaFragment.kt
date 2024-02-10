package com.example.islamapp.screens.home.fragments.sebha

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import com.example.islamapp.R
import com.example.islamapp.databinding.FragmentSebhaBinding

class SebhaFragment : Fragment() {
    lateinit var binding: FragmentSebhaBinding
    private var count = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSebhaBinding.inflate(inflater, container, false)
        return binding.root
    }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            binding.buttonCounter.setOnClickListener {
                count++
                binding.textInCounter.text = "$count"
                when(count) {

                    10 -> binding.textInSebha.text = "الحمدلله"
                    20 -> binding.textInSebha.text = "لا حول ولا قوة\n الا بالله"
                    30 -> binding.textInSebha.text = "االله اكبر"
                }
                movePrayerBead()
            }
        }


    private fun movePrayerBead() {
        val rotateAnimation: Animation = RotateAnimation(
            0f, 10f,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        )
        rotateAnimation.duration = 300 // مدة الدوران بالمللي ثانية (1 ثانية)
        rotateAnimation.repeatCount = 0 // عدد التكرارات، 0 تعني أنه سيتم تنفيذ الدوران مرة واحدة
        binding.bodyImageView.startAnimation(rotateAnimation)
    }
}

