package com.ganeshrashinkar.composepaging3caching.data.remote

data class BeerDTO (
    val id:Int,
    val name:String,
    val tagline:String,
    val description:String,
    val first_brewed:String,
    val image_url:String?
)