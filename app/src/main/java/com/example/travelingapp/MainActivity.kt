package com.example.travelingapp

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // Variables
    var topAnim : Animation? = null
    var bottomAnim : Animation? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        removeStatusBar()
        setContentView(R.layout.activity_main)

        initializeSplashScreen()
        startDashBoard()
    }

    private fun removeStatusBar() {
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }

    private fun initializeSplashScreen() {
        // Animation
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)

        splash_logo.animation = topAnim
        splash_title.animation = bottomAnim
        splash_description.animation = bottomAnim
    }

    private fun startDashBoard() {
        Handler().postDelayed({
            val intent: Intent = Intent(this, LoginActivity::class.java)

//            val image: View = splash_logo
//            val animName = "splash_logo_trans"
//
//            val pair1 = android.util.Pair(image, animName)
//            //val pair2 = Pair (splash_title, "splash_title_trans") // using declared variable in Pair class
//
//            val options: ActivityOptions? = ActivityOptions.makeSceneTransitionAnimation(this, pair1)
//            startActivity(intent, options?.toBundle())
            startActivity(intent)
            finish()
        }, SPLASH_SCREEN.toLong())
    }

    companion object {
        const val SPLASH_SCREEN = 3000
    }

}
