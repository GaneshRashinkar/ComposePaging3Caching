package com.ganeshrashinkar.composepaging3caching.domain

data class Beer(
    val id:Int,
    val name:String,
    val tagline:String,
    val description:String,
    val firstBrewed:String,
    val imageUrl:String?
)
