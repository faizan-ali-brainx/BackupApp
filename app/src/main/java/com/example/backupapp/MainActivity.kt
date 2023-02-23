package com.example.backupapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.backupapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var backupManager: BackupManagere

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        backupManager = BackupManagere(applicationContext)

        binding.apply {
            spWidget.text = backupManager.restore()
            btnInit.apply {
                setOnClickListener {
                    spWidget.text = "203030000"
                    isEnabled = false
                }
                isEnabled = spWidget.text.isNullOrEmpty()
            }
            backupButton.setOnClickListener {
                backupManager.backup()
            }
            restoreButton.setOnClickListener {
                backupManager.restore()
            }
        }

    }
}