package com.example.shoplist.model

import com.example.shoplist.data.ShoppingItem

interface ShoppingItemRepository {
    fun addItem(itemToAdd: ShoppingItem)
    fun getItemByTitle(title: String): ShoppingItem?
    fun updateItem(itemToUpdate: ShoppingItem)
    fun removeItem(itemToRemove: ShoppingItem)
    fun clearShoppingList()
    fun getAll(): List<ShoppingItem>
}