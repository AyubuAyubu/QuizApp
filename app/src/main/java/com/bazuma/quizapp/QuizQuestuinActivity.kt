package com.bazuma.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_quiz_questuin.*
//make our class to be clickListener
class QuizQuestuinActivity : AppCompatActivity(),View.OnClickListener {

    //start with first Question
    private var currentPosition:Int=1
    //object that can be used in order to set questionList
    private var mQuestionsList:ArrayList<Question>?=null
    private var selectedPosition:Int=0
    private var correctAnswers:Int=0
    private var mUserName:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questuin)

        //sent  when this activity was launch and then we pass the
        //Constants.USER_NAME onCreate event that will be pass to Result
        //Activity
         mUserName=intent.getStringExtra(Constants.USER_NAME)

         mQuestionsList=Constants.getQuestion()
         setQuestions()

        //make our button to have click listener
        tvOptionOne.setOnClickListener(this)
        tvOptiontwo.setOnClickListener(this)
        tvOptionThree.setOnClickListener(this)
        tvOptionFour.setOnClickListener(this)
        btnSubmit.setOnClickListener(this)
    }
    private fun setQuestions(){

        val myquestion=mQuestionsList!!.get(currentPosition-1)

        defaultOptionView()

        if (currentPosition==mQuestionsList!!.size){
            btnSubmit.text="FINISH"
        }else{
            btnSubmit.text="SUBMIT"
        }
        /* step 1
           Here we identify current position of the question
           Then we pass that position to progress bar 1/10
           them we check the id is not nullable if true
           we display the next question,flag and options related to
           that question
         */
        progressBar.progress=currentPosition
        tvProgressingBar.text="$currentPosition" + "/" +progressBar.max

        tvQuestionId.text=myquestion!!.Question
        iv_image.setImageResource(myquestion.image)

        tvOptionOne.text=myquestion.optionOne
        tvOptiontwo.text=myquestion.optionTwo
        tvOptionThree.text=myquestion.optionThree
        tvOptionFour.text=myquestion.optionFour
    }
    /*
    step 3
    This method is used to to make button to there fast
    appearance when we move to next question
    by changing textColor,typeFace and background to default
     */
    private fun defaultOptionView(){
        //This is used to add the options into the arrayList
        val options=ArrayList<TextView>()
        options.add(0,tvOptionOne)
        options.add(1,tvOptiontwo)
        options.add(2,tvOptionThree)
        options.add(3,tvOptionFour)

        //move through the options in the array list
        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            //Style which text should be display
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    override fun onClick(v: View?) {
            when(v?.id){
                R.id.tvOptionOne->{
                    selectedOptionView(tvOptionOne,1)
                }
                R.id.tvOptiontwo->{
                    selectedOptionView(tvOptiontwo,2)
                }
                R.id.tvOptionThree->{
                    selectedOptionView(tvOptionThree,3)
                }
                R.id.tvOptionFour->{
                    selectedOptionView(tvOptionFour,4)
                }
                R.id.btnSubmit->{
                    //Override the initial value  to 0
                    //mean we have not select any option
                    if (selectedPosition==0){
                        //We move to next Question by Increament current Position by 1
                        currentPosition++
                        when{
                            //We reset the Question
                            currentPosition<=mQuestionsList!!.size->{
                                setQuestions()
                            }else->{
                                val intent= Intent(this,ResultActivity::class.java)
                                intent.putExtra(Constants.USER_NAME,mUserName)
                                intent.putExtra(Constants.CORRECT_ANSWERS,correctAnswers)
                                intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionsList!!.size)
                                startActivity(intent)
                                finish()
                            }
                        }
                        //user as selected an option
                    }else{
                        val quiz=mQuestionsList?.get(currentPosition-1)
                        //not the same
                        if (quiz!!.correctAnswer!=currentPosition){
                            answerView(selectedPosition,R.drawable.wrong_option_border_bg)
                        }else{
                            correctAnswers++
                        }
                        answerView(quiz.correctAnswer,R.drawable.correct_option_border_bg)
                        if (currentPosition==mQuestionsList!!.size){
                            btnSubmit.text="FINISH"
                        }else{
                            btnSubmit.text="GO TO NEXT QUESTION"
                        }
                        //set back to 0
                        selectedPosition=0
                    }
                }
            }

    }
    //step 4
    private fun answerView(answer:Int,drawableView:Int){
            when(answer){
                1->{
                    tvOptionOne.background=ContextCompat.getDrawable(
                        this,drawableView
                    )
                }
                2->{
                    tvOptiontwo.background=ContextCompat.getDrawable(
                        this,drawableView
                    )
                }
                3->{
                    tvOptionThree.background=ContextCompat.getDrawable(
                        this,drawableView
                    )
                }
                4->{
                    tvOptionFour.background=ContextCompat.getDrawable(
                        this,drawableView
                    )
                }
            }
    }
    /*step 2
    This method is used to show the selected Button
    By changing Stroke Color to purple
     */
    private fun selectedOptionView(tv:TextView,selectOptionNo:Int){
        defaultOptionView()
        //new selected position
        selectedPosition=selectOptionNo
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }
}
