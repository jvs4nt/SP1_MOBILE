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
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    private lateinit var errorTextView: TextView
    private lateinit var registerButton: Button
    private lateinit var button2: Button
    private lateinit var loginEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var nameEditText: EditText
    private lateinit var confirmPasswordEditText: EditText
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        auth = FirebaseAuth.getInstance()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        errorTextView = findViewById(R.id.errorTextView)
        loginEditText = findViewById(R.id.loginEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        registerButton = findViewById(R.id.registerButton)
        button2 = findViewById(R.id.button2)
        nameEditText = findViewById(R.id.nameEditText)
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText)

        errorTextView.isVisible = false

        registerButton.setOnClickListener {
            register()
        }

        button2.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun register() {
        val username = loginEditText.text.toString()
        val password = passwordEditText.text.toString()
        val name = nameEditText.text.toString()
        val confirmPassword = confirmPasswordEditText.text.toString()

        if (username.isNotEmpty() && password.isNotEmpty() && name.isNotEmpty() && confirmPassword.isNotEmpty()) {
            errorTextView.setBackgroundColor(Color.parseColor("#96ff9d"))
            errorTextView.text = getString(R.string.registro_sucesso)
            errorTextView.isVisible = true
        } else {
            errorTextView.setBackgroundColor(Color.parseColor("#f76f7d"))
            errorTextView.text = getString(R.string.registro_erro)
            errorTextView.isVisible = true
        }
    }
}
