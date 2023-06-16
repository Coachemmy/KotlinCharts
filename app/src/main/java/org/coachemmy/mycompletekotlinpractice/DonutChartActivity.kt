package org.coachemmy.mycompletekotlinpractice

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.coachemmy.mycompletekotlinpractice.databinding.ActivityDonutChartBinding

class DonutChartActivity : AppCompatActivity() {

    private var _binding: ActivityDonutChartBinding? = null
    private  val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDonutChartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            donutChart.donutColors = intArrayOf(
                Color.parseColor("#0E5A9C"),
                Color.parseColor("#CD1212"),
                Color.parseColor("#52E628")

            )
            donutChart.animation.duration = animationDuration
            donutChart.animate(donutSet)

            close.setOnClickListener {
                startActivity(Intent(this@DonutChartActivity, TestActivity::class.java))
            }

        }
    }

    companion object{
        private val donutSet = listOf(
            40F,
            70F,
            52F
        )

        private const val animationDuration = 1000L
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}


