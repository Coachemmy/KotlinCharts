package org.coachemmy.mycompletekotlinpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.coachemmy.mycompletekotlinpractice.databinding.ActivityBarChartBinding

class BarChartActivity : AppCompatActivity() {

    private var _binding: ActivityBarChartBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityBarChartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            barChartVer.animation.duration = animationDuration
            barChartVer.animate(barSetVet)

            barChartHor.animation.duration = animationDuration
            barChartHor.animate(barSetHor)

            close.setOnClickListener {
                startActivity(Intent(this@BarChartActivity, TestActivity::class.java))
            }

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        private val barSetVet = listOf(
            "JAN" to 4F,
            "FEB" to 7F,
            "MAR" to 5.2F,
            "APR" to 1F,
            "MAY" to 5F,
            "JUN" to 4F,
        )

        private val barSetHor = listOf(
            "LAGOS" to 4F,
            "ABUJA" to 6F,
            "KANO" to 2.5F,
        )

        private const val animationDuration = 1000L
    }
}