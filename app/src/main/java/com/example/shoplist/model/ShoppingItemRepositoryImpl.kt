package com.example.shoplist.model

import com.example.shoplist.data.ShoppingItem

class ShoppingItemRepositoryImpl(
    val database: ArrayList<ShoppingItem>
): ShoppingItemRepository {
    override fun addItem(itemToAdd: ShoppingItem) {
        database.add(itemToAdd)
    }

    override fun getItemByTitle(title: String): ShoppingItem? {
        return database.find {
            it.title == title
        }
    }

    override fun updateItem(itemToUpdate: ShoppingItem) {
        val item = database.find {
            it.id == itemToUpdate.id
        }
        if(item != null){
            val itemIndex = database.indexOfFirst { it.id == itemToUpdate.id }
            if(itemIndex != -1){
                if(itemToUpdate.amount > 0){
                    database[itemIndex] = itemToUpdate
                }else{
                    removeItem(itemToUpdate)
                }
            }
        }
    }

    override fun removeItem(itemToRemove: ShoppingItem) {
        val itemIndex = database.indexOfFirst { it.id == itemToRemove.id }
        if(itemIndex != -1){
            database.removeAt(itemIndex)
        }
    }

    override fun clearShoppingList() {
        TODO("Not yet implemented")
    }

    override fun getAll() =
        database.toList()
}