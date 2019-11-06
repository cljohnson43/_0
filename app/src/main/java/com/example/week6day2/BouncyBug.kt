package com.example.week6day2

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat

class BouncyBug @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ImageView(context, attrs, defStyleAttr) {
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        setImageResource(R.drawable.ic_bug_droid)
        setBackgroundColor(resources.getColor(R.color.black))

        ImageViewCompat.setImageTintList(
            this,
            ContextCompat.getColorStateList(context, R.color.bug_green)
        )

    }

}