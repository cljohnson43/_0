package com.example.week6day2

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.Button
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat

class MainActivity : AppCompatActivity() {

    private lateinit var fireBtn: Button
    private lateinit var nextBtn: Button
    private lateinit var container: ViewGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        container = findViewById(R.id.container) as ViewGroup

        fireBtn = findViewById(R.id.btn_fire) as Button
        fireBtn.setOnClickListener { _ -> fire() }

        nextBtn = findViewById(R.id.btn_next)
        nextBtn.setOnClickListener {
            startActivity(Intent(this, BounceActivity::class.java))
        }

    }

    fun fire() {
        val bug = AppCompatImageView(this).apply {
            setImageResource(R.drawable.ic_bug_droid)
            setBackgroundColor(resources.getColor(R.color.black))
            layoutParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT
            )
        }
        ImageViewCompat.setImageTintList(
            bug,
            ContextCompat.getColorStateList(this, R.color.bug_green)
        )

        var bugH = bug.height.toFloat()
        var bugW = bug.width.toFloat()

        val scaleW = Math.random().toFloat() * 1.9f + 0.1f
        val scaleH = scaleW
        bug.scaleX = scaleW
        bug.scaleY = scaleH

        bugH *= scaleH
        bugW *= scaleW

        val containerH = container.height
        val containerW = container.width

        bug.translationX = (Math.random() * containerW).toFloat() - bugW / 2.0f
        bug.translationY = containerH.toFloat()


        container.addView(bug)

        val launchH = (Math.random() * containerH).toFloat() + bugH
        val launcher =
            ObjectAnimator.ofFloat(bug, View.TRANSLATION_Y, containerH.toFloat(), launchH).apply {
                interpolator = AccelerateDecelerateInterpolator()
                repeatCount = 1
                repeatMode = ObjectAnimator.REVERSE
            }

        val rotator = ObjectAnimator.ofFloat(bug, View.ROTATION, (Math.random() * 1080).toFloat())

        val set = AnimatorSet().apply {
            playTogether(rotator, launcher)
            duration = (Math.random() * 2500).toLong() + 1000
            addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    super.onAnimationEnd(animation)
                    container.removeView(bug)
                }
            })
        }
        set.start()

    }
}
