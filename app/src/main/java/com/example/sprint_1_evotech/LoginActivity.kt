package com.example.sprint_1_evotech

import android.content.Intent
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
    private lateinit var registerButton: Button
    private lateinit var forgotPasswordButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        errorTextView = findViewById(R.id.errorTextView)
        loginEditText = findViewById(R.id.loginEditText)
        senhaEditText = findViewById(R.id.senhaEditText)
        errorTextView.isVisible = false
        loginButton = findViewById(R.id.loginButton)
        registerButton = findViewById(R.id.button2)
        forgotPasswordButton = findViewById(R.id.forgotPasswordButton)

        loginButton.setOnClickListener {
            login()
        }

        registerButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        forgotPasswordButton.setOnClickListener {
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
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
