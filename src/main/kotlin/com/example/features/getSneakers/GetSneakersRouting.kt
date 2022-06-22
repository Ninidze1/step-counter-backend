package com.example.features.getSneakers

import com.example.database.sneakers.SneakersController
import com.example.features.getSneakers.model.SneakerCollection
import com.example.util.Constants.UTILS_DIR
import com.example.util.toObject
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.routing.*
import java.io.File

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json()
    }

    routing {
        get("/collection/fetch") {
            val sneakersController = SneakersController(call)
            sneakersController.fetchAllSneakers()
        }

        post("/collection/searchByName") {
            val sneakersController = SneakersController(call)
            sneakersController.searchSneakersByName()
        }

        post("/collection/add") {
            val sneakersController = SneakersController(call)
            sneakersController.addSneakers()
        }
    }
}