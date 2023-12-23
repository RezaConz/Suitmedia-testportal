package com.example.suitmedia_v2.network.models

data class UsersRespond(
    val data: ArrayList<UserClass>,
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int
)