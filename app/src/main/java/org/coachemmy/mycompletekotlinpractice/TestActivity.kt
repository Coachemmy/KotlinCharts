package org.coachemmy.mycompletekotlinpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import org.coachemmy.mycompletekotlinpractice.databinding.ActivityTestBinding

class TestActivity : AppCompatActivity() {

    private var _binding: ActivityTestBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            btnBarChart.setOnClickListener {
                startActivity(Intent(this@TestActivity, BarChartActivity::class.java))
            }

            btnDonutChart.setOnClickListener {
                startActivity(Intent(this@TestActivity, DonutChartActivity::class.java))
            }

            btnLineChart.setOnClickListener {
                startActivity(Intent(this@TestActivity, LineChartActivity::class.java))
            }
        }
    }
}