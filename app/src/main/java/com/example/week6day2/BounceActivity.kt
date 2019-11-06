package com.example.week6day2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.week6day2.databinding.ActivityBounceBinding

class BounceActivity : AppCompatActivity() {

    private val viewModel: ScoreViewModel by lazy {
        ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(ScoreViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityBounceBinding>(this, R.layout.activity_bounce)

        binding.viewModel = viewModel
    }
}
