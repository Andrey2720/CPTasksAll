package com.example.cptasks.data

data class UserModel(
    val id: Int,
    val name: String,
    val surename: String,
    val patronymic: String,
    val email: String,
    val role: String,
    val group_tb_id: Int,
    val password: String
)

data class TaskModel(
    val id: Int,
    val name: String,
    val description: String,
    val status: Int,
    val creation_date: String,
    val date_start: String,
    val date_end: String,
    val time_start: String,
    val time_end: String,
    val user_tb_id: Int
)