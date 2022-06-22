package com.example.database.sneakers

import kotlinx.serialization.Serializable

@Serializable
class SneakersDTO(
    val tokenId: String?,
    val name: String?,
    val imageUrl: String?,
    val favoritesCount: Int?,
    val price: Int?
)