package com.example.database.sneakers

import com.example.features.getSneakers.model.CollectionItem
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*

class SneakersController(private val call: ApplicationCall) {

    suspend fun fetchAllSneakers() {
        call.respond(Sneakers.fetchSneakers())
    }

    suspend fun searchSneakersByName() {
        val request = call.receive<String>()
        call.respond(Sneakers.fetchSneakers().filter {
            it.name?.contains(request, ignoreCase = true) ?: true
        })
    }

    suspend fun addSneakers() {
        val request = call.receive<CollectionItem>()
        val sneakers = request.mapToDTO()
        Sneakers.insert(sneakers)
    }

}