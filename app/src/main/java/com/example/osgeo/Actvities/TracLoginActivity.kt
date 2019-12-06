package com.example.osgeo.Actvities

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.osgeo.R


class TracLoginActivity : AppCompatActivity() {

    private var emailText: EditText? = null
    private var passwordText: EditText? = null
    private var loginButton: Button? = null

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trac_login)

        loginButton = findViewById(R.id.btn_login_trac)
        passwordText = findViewById(R.id.input_password_trac)
        emailText = findViewById(R.id.input_email_trac)
        loginButton!!.setOnClickListener { login() }
    }
    private fun login() {
        Log.d(TAG, "Login")

        if (!validate()) {
            onLoginFailed()
            return
        }


        Toast.makeText(baseContext, "Login Successful", Toast.LENGTH_LONG).show()

        loginButton!!.isEnabled = false

    }

    private fun onLoginFailed() {
        Toast.makeText(baseContext, "Login failed", Toast.LENGTH_LONG).show()

        loginButton!!.isEnabled = true
    }

    private fun validate(): Boolean {
        var valid = true

        val email = emailText!!.text.toString()
        val password = passwordText!!.text.toString()

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailText!!.error = "enter a valid email address"
            valid = false
        } else {
            emailText!!.error = null
        }

        if (password.isEmpty() || password.length < 4 || password.length > 10) {
            passwordText!!.error = "between 4 and 10 alphanumeric characters"
            valid = false
        } else {
            passwordText!!.error = null
        }

        return valid
    }

    companion object {
        private const val TAG = "LoginActivity"
        private const val REQUEST_SIGNUP = 0
    }
}
