package com.example.cptasks.data


data class ItemTaskModel(
    val id: Int,
    val name: String,
    val description: String,
    val status: String,
    val creation_date: String,
    val date_start: String,
    val date_end: String,
    val time_start: String,
    val time_end: String,
    val user_tb_id: Int
)

