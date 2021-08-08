package com.bazuma.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //get rid of status bar
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN


        btnStart.setOnClickListener {
            //Check for entry in the name text box
            if (et_name.text.toString().isEmpty()){
                Toast.makeText(this,
                    "Enter your name please",Toast.LENGTH_SHORT).show()
            }else{
                //Move to next screen using intent
                val intent=Intent(this,
                    QuizQuestuinActivity::class.java)
                //key and where do we get username
                intent.putExtra(Constants.USER_NAME,et_name.text.toString())
                startActivity(intent)
                //close current activity
                finish()
            }
       }
    }
}