package com.bariscraft.turbo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bariscraft.turbo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = getSharedPreferences("Turbo", MODE_PRIVATE).getString("name", "Musab")
        binding.tvGreeting.text = "Merhaba $name, seni dinliyorum..."

        binding.btnMic.setOnClickListener {
            Toast.makeText(this, "Dinleme başlatıldı", Toast.LENGTH_SHORT).show()
        }
    }
}
