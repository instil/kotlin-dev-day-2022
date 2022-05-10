package suspending

import breakfast.model.Beverage
import breakfast.model.Breakfast
import breakfast.model.Food
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main() = runBlocking {
    printInDetail("Program starts")
    val client = buildHttpClient()
    client.use {
        val breakfast = orderBreakfast(client)
        printInDetail("Breakfast ordered")
        breakfast.consume()
    }
    printInDetail("Program ends")
}

suspend fun orderBreakfast(client: HttpClient): Breakfast = withContext(Dispatchers.IO) {
    printInDetail("Ordering breakfast")

    val beverage: Beverage = orderBeverage(client)
    val food: Food = orderFood(client, beverage)
    Breakfast(beverage, food)
}

private suspend fun orderFood(it: HttpClient, beverage: Beverage): Food =
    it.post("/breakfast/food") {
        setBody(beverage)
        contentType(ContentType.Application.Json)
    }.body()

private suspend fun orderBeverage(it: HttpClient): Beverage =
    it.get("/breakfast/beverage") {
        accept(ContentType.Application.Json)
    }.body()
