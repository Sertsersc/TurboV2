package com.bariscraft.turbo

import android.os.Bundle
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bariscraft.turbo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Madde 7: İsim Karşılama
        val name = getSharedPreferences("Turbo", MODE_PRIVATE).getString("name", "Musab")
        binding.tvGreeting.text = "Merhaba $name, nasıl yardımcı olabilirim?"

        binding.btnMic.setOnClickListener {
            // Örnek Komut İşleme
            handleCommand("dedeme yazmadan geliyorum yaz")
        }
    }

    private fun handleCommand(cmd: String) {
        val input = cmd.lowercase()
        when {
            // Madde 4: Yazma (WA) vs Yaz (SMS)
            input.contains("yazma") -> {
                // WhatsApp Mantığı
                val msg = input.substringAfter("yazma ")
                Toast.makeText(this, "WhatsApp: $msg", Toast.LENGTH_LONG).show()
            }
            input.contains("yaz") -> {
                // SMS Mantığı
                Toast.makeText(this, "SMS Gönderiliyor...", Toast.LENGTH_LONG).show()
            }
            // Madde 6: Sistem Ayarları
            input.contains("bluetooth aç") -> {
                startActivity(Intent(Settings.ACTION_BLUETOOTH_SETTINGS))
            }
            // Madde 5: YouTube & Studio
            input.contains("video paneli") -> {
                val intent = packageManager.getLaunchIntentForPackage("com.google.android.apps.youtube.creator")
                if (intent != null) startActivity(intent)
            }
            // Madde 8: Groq AI Geçişi
            else -> {
                Toast.makeText(this, "Groq AI Devreye Giriyor...", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
