package com.example.shoplist.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shoplist.model.ShoppingItemRepository

class ShoppingListViewModelFactory(val repository: ShoppingItemRepository):
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass == ShoppingListViewModel::class.java){
            return ShoppingListViewModel(repository) as T
        }
        return super.create(modelClass)
    }
}