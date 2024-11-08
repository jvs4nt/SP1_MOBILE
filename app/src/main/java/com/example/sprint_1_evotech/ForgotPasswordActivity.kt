package com.example.sprint_1_evotech

import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sprint_1_evotech.R

class ForgotPasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val loginEditText = findViewById<EditText>(R.id.loginEditText)
        val errorTextView = findViewById<TextView>(R.id.errorTextView)
        val loginButton = findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {
            val emailInput = loginEditText.text.toString().trim()

            if (isValidEmail(emailInput)) {
                // Limpa a mensagem de erro
                errorTextView.visibility = View.GONE
                // Lógica para enviar e-mail de recuperação (futura implementação)
            } else {
                // Exibe mensagem de erro
                errorTextView.text = getString(R.string.erro_email_invalido)
                errorTextView.visibility = View.VISIBLE
            }
        }
    }

    private fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}
