package com.bazuma.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val username=intent.getStringExtra(Constants.USER_NAME)
        tvUserName.text=username

        val totalQuestion=intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctResult=intent.getIntExtra(Constants.CORRECT_ANSWERS,0)

        tvScore.text="Your score is $correctResult out $totalQuestion"

        btnFinish.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

    }
}