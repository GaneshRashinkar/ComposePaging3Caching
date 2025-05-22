package com.ganeshrashinkar.composepaging3caching.data.remote

import com.ganeshrashinkar.composepaging3caching.data.local.BeerEntity
import com.ganeshrashinkar.composepaging3caching.domain.Beer

fun BeerDTO.toBeerEntity(): BeerEntity {
    return BeerEntity(
        id = id,
        name = name,
        tagline = tagline,
        description = description,
        firstBrewed = first_brewed,
        imageUrl= image_url
    )
}

fun BeerEntity.toBeer():Beer{
    return Beer(
        id = id,
        name = name,
        tagline = tagline,
        description = description,
        firstBrewed = firstBrewed,
        imageUrl=imageUrl
    )
}