package com.example.domain.modul

import com.google.gson.annotations.SerializedName

data class Hotel(
    val id: Int,
    val name: String,
    val adress: String,
    val minimal_price: Int,
    val price_for_it: String,
    val rating: Int,
    val rating_name: String,
    val image_urls: List<String>,
    @SerializedName("about_the_hotel")
    val hotelDetails: HotelDetails
)

