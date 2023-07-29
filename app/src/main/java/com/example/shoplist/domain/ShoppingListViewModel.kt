package com.example.shoplist.domain

import androidx.lifecycle.ViewModel
import com.example.shoplist.data.ShoppingItem
import com.example.shoplist.model.ShoppingItemRepository

class ShoppingListViewModel(
    val repository: ShoppingItemRepository
) : ViewModel(){
    fun addItem(item: ShoppingItem){
        repository.addItem(item)
    }

    fun removeItem(item: ShoppingItem){
        repository.removeItem(item)
    }

    fun updateItem(item: ShoppingItem){
        repository.updateItem(item)
    }

    fun clearShoppingList(){
        repository.clearShoppingList()
    }

    fun getAll(): List<ShoppingItem>{
        return repository.getAll()
    }
}