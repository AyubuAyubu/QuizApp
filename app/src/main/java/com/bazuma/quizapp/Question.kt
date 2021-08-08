package com.bazuma.quizapp

//It will know about question text,different option and which
//one of the option is correct and no method
data class Question(
    val id:Int,
    val Question:String,
    val image:Int,
    val optionOne:String,
    val optionTwo:String,
    val optionThree:String,
    val optionFour:String,
    val correctAnswer:Int
)

