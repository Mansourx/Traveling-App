package com.example.travelingapp

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    // Variables
    private var name: String? = null
    private var userName: String? = null
    private var email: String? = null
    private var phoneNumber: String? = null
    private var password: String? = null
    private var signUpBtn: Button? = null
    private var loginBtn: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        removeStatusBar()
    }

    private fun removeStatusBar() {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }

    fun registerUser(view: View) {
        name = name_et.editText?.text.toString()
        userName = username_et.editText?.text.toString()
        email = email_et.editText?.text.toString()
        phoneNumber = phone_et.editText?.text.toString()
        password = password_et.editText?.text.toString()

        validateSignUpForm()
    }

    private fun validateSignUpForm() {
        var notValid = false

        if (!validateName()) {
            notValid = true
        }
        if (!validateUserName()) {
            notValid = true
        }
        if (!validateEmail()) {
            notValid = true
        }
        if (!validatePhoneNumber()) {
            notValid = true
        }
        if (!validatePassword()) {
            notValid = true
        }

        if (notValid)
            return
    }

    private fun validateName(): Boolean {
        val value = name_et.editText?.text.toString()

        return if (value.isEmpty()) {
            name_et.error = "Name cannot be empty!"
            false
        } else {
            name_et.editText?.error = null
            name_et.isErrorEnabled = false
            true
        }
    }

    private fun validateUserName(): Boolean {
        val value = username_et.editText?.text.toString()
        val noWhiteSpace = "\\A\\w{2,20}\\z".toRegex()

        return when {
            value.isEmpty() -> {
                username_et?.error = "Username cannot be empty!"
                false
            }
            value.length >= 15 -> {
                username_et?.error = "UserName too long!"
                false
            }
            value.length < 4 -> {
                username_et?.error = "UserName too short!"
                false
            }
            !value.matches(noWhiteSpace) -> {
                username_et?.error = "No White space allowed!"
                false
            }
            else -> {
                username_et.editText?.error = null
                username_et.isErrorEnabled = false
                true
            }
        }
    }

    private fun validateEmail(): Boolean {
        val value = email_et.editText?.text.toString()
        val emailRegex = ("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" + "\\@"
                + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" + "(" + "\\."
                + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+").toRegex()

        return when {
            value.isEmpty() -> {
                email_et?.error = "Email cannot be empty!"
                false
            }
            !value.matches(emailRegex) -> {
                email_et?.error = "Invalid email address!"
                false
            }
            else -> {
                email_et?.error = null
                email_et.isErrorEnabled = false
                true
            }
        }
    }

    private fun validatePhoneNumber(): Boolean {
        val value = phone_et.editText?.text.toString()

        return if (value.isEmpty()) {
            phone_et?.error = "Phone Number cannot be empty!"
            false
        } else {
            phone_et?.error = null
            phone_et.isErrorEnabled = false
            true
        }
    }

    private fun validatePassword(): Boolean {
        val value = password_et.editText?.text.toString()
        val passwordReg =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$".toRegex()

        return when {
            value.isEmpty() -> {
                password_et?.error = "password cannot be empty!"
                password_et?.errorIconDrawable = null
                false
            }
            !value.matches(passwordReg) -> {
                password_et?.error = "password is too weak!"
                password_et?.errorIconDrawable = null
                false
            }
            else -> {
                password_et?.error = null
                password_et.isErrorEnabled = false
                true
            }
        }
    }

}
