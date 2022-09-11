package com.example.geoquiz

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "QuizViewModel"

class QuizViewModel : ViewModel() {
    var currentIndex = 0

    private val questionBank = listOf(
        Question(R.string.question_australia, answer = true, answered = false),
        Question(R.string.question_oceans, answer = true, answered = false),
        Question(R.string.question_mideast, answer = false, answered = false),
        Question(R.string.question_africa, answer = false, answered = false),
        Question(R.string.question_americas, answer = true, answered = false),
        Question(R.string.question_asia, answer = true, answered = false),
    )

    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId

    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer

    var currentQuestionAnswered: Boolean
        get() = questionBank[currentIndex].answered
        set(newStatus) {
            questionBank[currentIndex].answered = newStatus
        }

    fun moveToNext() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }

    fun moveToPrev() {
        currentIndex = if (currentIndex > 0) currentIndex - 1 else questionBank.size - 1
    }
}