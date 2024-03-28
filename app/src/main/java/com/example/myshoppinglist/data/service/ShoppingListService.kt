package com.example.myshoppinglist.data.service

import com.example.myshoppinglist.data.dto.ShoppingList
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.UUID

interface ShoppingListService {
    @GET("shopping-lists/{id}")
    suspend fun getShoppingListById(
        @Path("id") id: UUID,
    ): ShoppingList {
        val a: Int = 2
        return TODO("Provide the return value")
    }
}