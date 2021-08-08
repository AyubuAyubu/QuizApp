package com.bazuma.quizapp

//file and is constant
object Constants{

    const val USER_NAME:String="user_name"
    const val TOTAL_QUESTIONS:String="total_question"
    const val CORRECT_ANSWERS:String="correct_ans"

    //Get all of different functions
    fun getQuestion():ArrayList<Question>{
        val questionList=ArrayList<Question>()

        val quiz1=Question(
            1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_togo,
            "Tanzania",
            "Togo",
            "Kenya",
            "Botswana",
            2
        )
        questionList.add(quiz1)
        val quiz2=Question(
            2,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_nigeria,
            "DRC Congo",
            "Nigeria",
            "Namibia",
            "Angola",
            2
        )
        questionList.add(quiz2)
        val quiz3=Question(
            3,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_cameroon,
            "Somalia",
            "Burundi",
            "Uganda",
            "Cameroon",
            4
        )
        questionList.add(quiz3)
        val quiz4=Question(
            4,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_comoros,
            "Comoros",
            "Egypt",
            "Chad",
            "Gambia",
            1
        )
        questionList.add(quiz4)
        val quiz5=Question(
            5,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_djibouti,
            "Ghana",
            "Djibouti",
            "Gabon",
            "Sudan",
            2
        )
        questionList.add(quiz5)
        val quiz6=Question(
            6,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_tanzania,
            "South Africa",
            "Lesotho",
            "Libya",
            "Tanzania",
            4
        )
        questionList.add(quiz6)
        val quiz7=Question(
            7,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_senegal,
            "Mali",
            "Morocco",
            "Niger",
            "Senegal",
            4
        )
        questionList.add(quiz7)
        val quiz8=Question(
            8,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_seychelles,
            "Seychelles",
            "Zambia",
            "South Sudan",
            "Zimbabwe",
            1
        )
        questionList.add(quiz8)
        val quiz9=Question(
            9,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_mauritania,
            "Mozambique",
            "Mauritus",
            "Mauritania",
            "Malawi",
            3
        )
        questionList.add(quiz9)
        val quiz10=Question(
            10,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_sierra,
            "Eritrea",
            "Egypt",
            "Sierre Leone",
            "Somalia",
            3
        )
        questionList.add(quiz10)

        return questionList
    }

}