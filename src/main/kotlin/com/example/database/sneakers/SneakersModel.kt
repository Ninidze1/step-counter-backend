package com.example.database.sneakers

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

object Sneakers : Table() {
    private val tokenId = Sneakers.varchar("tokenId", 10).nullable()
    private val name = Sneakers.varchar("name", 50).nullable()
    private val imageUrl = Sneakers.varchar("imageUrl", 200).nullable()
    private val favoritesCount = Sneakers.integer("favoritesCount").nullable()
    private val price = Sneakers.integer("price").nullable()

    fun insert(sneakersDTO: SneakersDTO) {
        transaction {
            Sneakers.insert {
                it[tokenId] = sneakersDTO.tokenId
                it[name] = sneakersDTO.name
                it[imageUrl] = sneakersDTO.imageUrl
                it[favoritesCount] = sneakersDTO.favoritesCount
                it[price] = sneakersDTO.price
            }
        }
    }

    fun fetchSneakers(): List<SneakersDTO> {
        return try {
            transaction {
                Sneakers.selectAll().toList()
                    .map {
                        SneakersDTO(
                            tokenId = it[tokenId],
                            name = it[name],
                            imageUrl = it[imageUrl],
                            favoritesCount = it[favoritesCount],
                            price = it[price]

                        )
                    }
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

}