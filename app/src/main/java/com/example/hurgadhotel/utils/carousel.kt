package com.example.hurgadhotel.utils

import android.content.Context
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.viewpager2.widget.ViewPager2
import com.example.hurgadhotel.R

fun createAndUpdateDotIndicator(photos: List<String>, context: Context, indicatorLayout: LinearLayout, photoPager: ViewPager2) {
    if (photos?.indices != null) {
        for (i in photos.indices) {
            val dot = ImageView(context)
            dot.setImageResource(R.drawable.indicator_dot)
            dot.isSelected = (i == 0)
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(8, 0, 8, 0)
            dot.layoutParams = params
            indicatorLayout.addView(dot)
        }

        photoPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                for (i in 0 until indicatorLayout.childCount) {
                    indicatorLayout.getChildAt(i).isSelected = (i == position)
                }
            }
        })
    }
}