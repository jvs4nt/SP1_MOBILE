package com.example.sprint_1_evotech

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.example.sprint_1_evotech.R

class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var loginEditText: EditText
    private lateinit var errorTextView: TextView
    private lateinit var sendButton: Button
    private lateinit var voltarButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        loginEditText = findViewById(R.id.loginEditText)
        errorTextView = findViewById(R.id.errorTextView)
        errorTextView.isVisible = false
        sendButton = findViewById(R.id.sendButton)
        voltarButton = findViewById(R.id.voltarButton)

        sendButton.setOnClickListener {
            val loginInput = loginEditText.text.toString()

            if (loginInput.isNotEmpty()) {
                errorTextView.setBackgroundColor(Color.parseColor("#96ff9d"))
                errorTextView.text = getString(R.string.email_enviado)
                errorTextView.isVisible = true

                // Lógica para enviar e-mail de recuperação (futura implementação)
            } else {
                errorTextView.setBackgroundColor(Color.parseColor("#f76f7d"))
                errorTextView.text = getString(R.string.login_vazio)
                errorTextView.isVisible = true
            }
        }

        voltarButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}
