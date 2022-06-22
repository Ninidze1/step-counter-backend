package com.example

import com.example.features.getSneakers.configureSerialization
import com.example.plugins.configureRouting
import io.ktor.server.cio.*
import io.ktor.server.engine.*
import org.jetbrains.exposed.sql.Database

fun main() {
    Database.connect(
        url = "jdbc:postgresql://localhost:5432/collection",
        driver = "org.postgresql.Driver",
        user = "postgres",
        password = "191023"
    )
    embeddedServer(CIO, port = 8080, host = "0.0.0.0") {
        configureRouting()
        configureSerialization()
    }.start(wait = true)
}
