package com.example.sprint_1_evotech

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible

class LoginActivity : AppCompatActivity() {
    private lateinit var errorTextView: TextView
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        errorTextView = findViewById<TextView>(R.id.errorTextView)
        errorTextView.isVisible = false
        loginButton = findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener() {
            login()
        }

    }

    private fun login() {
        errorTextView.text = getString(R.string.usuario_nao_encontrado)
        errorTextView.isVisible = true
    }
}