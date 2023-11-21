package com.example.domain.modul

import com.google.gson.annotations.SerializedName

data class ListRooms(
    val rooms: List<Room>,
)
data class Room(
    val id: Long,
    val name: String,
    val price: Long,
    @SerializedName("price_per")
    val pricePer: String,
    val peculiarities: List<String>,
    @SerializedName("image_urls")
    val imageUrls: List<String>,
)
