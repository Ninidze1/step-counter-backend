package com.example.features.getSneakers.model

import com.example.util.JSONConvertable
import kotlinx.serialization.Serializable

@Serializable
data class SneakerCollection(
    val collection: List<CollectionItem>
): JSONConvertable