package com.example.features.getSneakers.model

import com.example.database.sneakers.SneakersDTO
import com.example.util.JSONConvertable
import kotlinx.serialization.Serializable

@Serializable
data class CollectionItem(
    val tokenId: String,
    val favoritesCount: Int,
    val imageUrl: String,
    val name: String,
    val price: Int? = null
): JSONConvertable {

    fun mapToDTO(): SneakersDTO {
        return SneakersDTO(
            tokenId = this.tokenId,
            name = this.name,
            imageUrl = this.imageUrl,
            favoritesCount = this.favoritesCount,
            price = (1..500).random() * 100
        )
    }

}