package com.example.travelingapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Html
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.example.travelingapp.adapters.OnBoardingSliderAdapter
import kotlinx.android.synthetic.main.activity_on_boarding.*


class OnBoardingActivity : AppCompatActivity() {

    // Variables
    private val slideImages: ArrayList<Int> = ArrayList()
    private val slideHeadings: ArrayList<String> = ArrayList()
    private val slideDescriptions: ArrayList<String> = ArrayList()
    private var slideAdapter: OnBoardingSliderAdapter? = null
    private lateinit var mDots: ArrayList<TextView>
    private var mCurrentPage: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)
        setSlideImages()
        setSlideHeadings()
        setSlideDescriptions()
        setupSlideAdapter()
        addDotsIndicator(0)
    }

    private fun setupSlideAdapter() {
        slideAdapter = OnBoardingSliderAdapter(
            context = this, slideImages = slideImages,
            slideHeadings = slideHeadings, slideDescriptions = slideDescriptions
        )
        on_boarding_viewpager?.adapter = slideAdapter
        setSliderOnChangeListener()
        back_btn.setOnClickListener {
            on_boarding_viewpager.currentItem = mCurrentPage - 1
        }
        next_btn.setOnClickListener {
            if (mCurrentPage < mDots.size - 1) {
                on_boarding_viewpager.currentItem = mCurrentPage + 1
            } else {
                intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun setSliderOnChangeListener() {
        on_boarding_viewpager?.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {
                addDotsIndicator(position)
                mCurrentPage = position
                when (position) {
                    0 -> {
                        next_btn.isEnabled = true
                        back_btn.isEnabled = false
                        back_btn.visibility = GONE

                        next_btn.visibility = VISIBLE
                        next_btn.text = "NEXT"
                        back_btn.text = ""
                    }
                    mDots.size - 1 -> {
                        next_btn.isEnabled = true
                        back_btn.isEnabled = true
                        back_btn.visibility = VISIBLE

                        next_btn.visibility = VISIBLE
                        next_btn.text = "FINISH"
                        back_btn.text = "BACK"
                    }
                    else -> {
                        next_btn.isEnabled = true
                        back_btn.isEnabled = true
                        back_btn.visibility = VISIBLE
                        next_btn.visibility = VISIBLE
                        next_btn.text = "NEXT"
                        back_btn.text = "BACK"
                    }
                }

            } })
    }

    private fun setSlideImages() {
        slideImages?.add(R.drawable.group_10)
        slideImages?.add(R.drawable.group_11)
        slideImages?.add(R.drawable.group_12)
    }

    private fun setSlideHeadings() {
        slideHeadings?.add("EAT")
        slideHeadings?.add("SLEEP")
        slideHeadings?.add("CODE")
    }

    private fun setSlideDescriptions() {
        slideDescriptions?.add("80% of sales commission calculations contain errors ")
        slideDescriptions?.add(
            "80% of sales commission calculations contain errors " +
                    "(a process that's historically been managed in spreadsheets)."
        )
        slideDescriptions?.add(
            "80% of sales commission calculations contain errors " +
                    "(a process that's historically been managed in spreadsheets)." +
                    " That's why we are excited to partner with CaptivateIQ as they help "
        )
    }

    private fun addDotsIndicator(pos: Int) {
        mDots = ArrayList()
        indicators_layout?.removeAllViews()
        for (i in 0 until slideHeadings?.size) {
            mDots.add(TextView(this))
            mDots[i].text = Html.fromHtml("&#8226;")
            mDots[i].textSize = 35F
            mDots[i].setTextColor(Color.parseColor("#cccccc"))

            indicators_layout?.addView(mDots[i])
        }

        if (mDots.size > 0) {
            mDots[pos].setTextColor(Color.parseColor("#FFFFFF"))
        }
    }

}
