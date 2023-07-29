package com.example.shoplist.domain

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoplist.data.ShoppingItem
import com.example.shoplist.model.ShoppingItemRepository

class ShoppingListViewModel(
    val repository: ShoppingItemRepository
) : ViewModel(){

    val databaseData: MutableLiveData<List<ShoppingItem>> = MutableLiveData()
    val lastImageUriData: MutableLiveData<Uri> = MutableLiveData()
    fun addItem(item: ShoppingItem){
        repository.addItem(item)
        databaseData.value = getAll()
    }

    fun removeItem(item: ShoppingItem){
        repository.removeItem(item)
        databaseData.value = getAll()
    }

    fun updateItem(item: ShoppingItem){
        repository.updateItem(item)
        databaseData.value = getAll()
    }

    fun clearShoppingList(){
        repository.clearShoppingList()
        databaseData.value = getAll()
    }

    fun getAll(): List<ShoppingItem>{
        return repository.getAll()
    }

    fun setImageUri(imageUri: Uri) {
        lastImageUriData.value = imageUri
    }
}