package com.example.shoplist

import android.app.Application
import com.example.shoplist.model.ShoppingItemRepository
import com.example.shoplist.model.ShoppingItemRepositoryImpl
import com.example.shoplist.utils.Utils.dataSet

class MyApp: Application() {
    lateinit var ShoppingItemRepository: ShoppingItemRepository
    override fun onCreate() {
        super.onCreate()
        ShoppingItemRepository = ShoppingItemRepositoryImpl(database = dataSet)
    }

}