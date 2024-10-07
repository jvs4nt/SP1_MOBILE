package com.example.sprint_1_evotech

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible

class LoginActivity : AppCompatActivity() {
    private lateinit var errorTextView: TextView
    private lateinit var loginButton: Button
    private lateinit var loginEditText: EditText
    private lateinit var senhaEditText: EditText

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
        loginEditText = findViewById<EditText>(R.id.loginEditText)
        senhaEditText = findViewById<EditText>(R.id.senhaEditText)
        errorTextView.isVisible = false
        loginButton = findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener() {
            login()
        }

    }

    private fun login() {
        if (loginEditText.text.toString() == "admin" && senhaEditText.text.toString() == "password") {
            errorTextView.setBackgroundColor(Color.parseColor("#96ff9d"))
            errorTextView.text = getString(R.string.usuario_encontrado)
            errorTextView.isVisible = true
        } else {
            errorTextView.setBackgroundColor(Color.parseColor("#f76f7d"))
            errorTextView.text = getString(R.string.usuario_nao_encontrado)
            errorTextView.isVisible = true
        }
    }
}