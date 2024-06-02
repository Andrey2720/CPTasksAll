package com.example.cptasks.data

import java.text.SimpleDateFormat


    fun FormaterDate(date: String): String{

        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        val outputFormat = SimpleDateFormat("yyyy-MM-dd")
        val inputDate = inputFormat.parse(date)
        val outputDateStr = outputFormat.format(inputDate)


        return outputDateStr
    }

    fun FormaterTime(date: String): String{

        val inputFormat = SimpleDateFormat("HH:mm:ss")
        val outputFormat = SimpleDateFormat("HH:mm")
        val inputDate = inputFormat.parse(date)
        val outputDateStr = outputFormat.format(inputDate)


        return outputDateStr
    }

    fun FormaterDateTime(date: String): String{

        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        val outputFormat = SimpleDateFormat("yyyy-MM-dd HH:mm")
        val inputDate = inputFormat.parse(date)
        val outputDateStr = outputFormat.format(inputDate)


        return outputDateStr
    }
