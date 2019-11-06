package com.example.week6day2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {
    private val _score by lazy {
        MutableLiveData<Int>().apply {
            value = 0
        }
    }
    val score: LiveData<Int>
        get() = _score

    fun increment() {
        _score.value?.plus(1)
    }
}