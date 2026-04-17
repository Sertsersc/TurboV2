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

        binding.tvGreeting.text = "Seni dinliyorum Musab..."

        binding.btnMic.setOnClickListener {
            Toast.makeText(this, "Mikrofon aktif!", Toast.LENGTH_SHORT).show()
        }
    }
}
