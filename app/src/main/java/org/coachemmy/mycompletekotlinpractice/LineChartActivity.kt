package org.coachemmy.mycompletekotlinpractice

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.db.williamchart.view.LineChartView
import org.coachemmy.mycompletekotlinpractice.databinding.ActivityLineChartBinding

class LineChartActivity : AppCompatActivity() {

    private var _binding: ActivityLineChartBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLineChartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            lineChart.gradientFillColors = intArrayOf(
                Color.parseColor("#CD1212"),
                Color.TRANSPARENT
            )

            lineChart.animation.duration = animationDuration
            lineChart.animate(lineSet)
            lineChart.onDataPointTouchListener = {index, _, _ ->
                tvChartData.text = lineSet.toList()[index].first.toString()
            }

            close.setOnClickListener {
                startActivity(Intent(this@LineChartActivity, TestActivity::class.java))
            }

        }
    }

    companion object{
        private var lineSet = listOf(
            "Ikeja" to 4F,
            "Abule-egba" to 6F,
            "Ojota" to 10F,
            "Yaba" to 4.5F,
            "Ikoyi" to 16F,
            "Agege" to 4F,
            "Oshodi" to 12F,
            "Epe" to 22F,
        )
        private const val animationDuration = 1000L
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
