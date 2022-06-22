package com.example

import com.example.features.getSneakers.configureSerialization
import com.example.plugins.configureRouting
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.server.cio.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.jetbrains.exposed.sql.Database

fun main() {
    val config = HikariConfig("hikari.properties")
    val dataSource = HikariDataSource(config)
    Database.connect(dataSource)

    embeddedServer(Netty, port = System.getenv("PORT").toInt()) {
        configureRouting()
        configureSerialization()
    }.start(wait = true)
}
//embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
//Database.connect(
//url = "jdbc:postgresql://localhost:5432/collection",
//driver = "org.postgresql.Driver",
//user = "postgres",
//password = "191023"
//)