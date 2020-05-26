package com.example.travelingapp

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        removeStatusBar()
        initialize()
    }

    private fun removeStatusBar() {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }

    private fun initialize() {
        sign_up_btn.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            val image: View = login_logo
            val animName = "splash_logo_trans"
            val pair = android.util.Pair(image, animName)

            val options: ActivityOptions? = ActivityOptions
                .makeSceneTransitionAnimation(this, pair)
            startActivity(intent, options?.toBundle())
        }
    }

    fun startMyProfile(view: View) {
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
    }

}
