package com.example.drive.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.example.drive.R
import kotlinx.android.synthetic.main.on_boarding_slide_layout.view.*


/**
 * Created by Ahmad Mansour on 28/05/2020
 * Dubai, UAE.
 */


class OnBoardingSliderAdapter(
    private val context: Context,
    private val slideImages: ArrayList<Int>,
    private val slideHeadings: ArrayList<String>,
    private val slideDescriptions: ArrayList<String>
) : PagerAdapter() {


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.on_boarding_slide_layout, null)

        var slideImageView: ImageView? = view.image_view as ImageView?
        var slideHeading: TextView? = view.heading_text as TextView?
        var slideDescription: TextView? = view.description_text as TextView?

        slideImageView?.setImageResource(slideImages[position])
        slideHeading?.text = slideHeadings[position]
        slideDescription?.text = slideDescriptions[position]

        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as RelativeLayout)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return slideHeadings.size
    }

}