package com.example.shoplist.data

import com.example.shoplist.adapters.ItemsListAdapter.Companion.VIEW_TYPE_IMAGE_ITEM
import com.example.shoplist.adapters.ItemsListAdapter.Companion.VIEW_TYPE_TEXT_ITEM

data class ShoppingItem(
    val id: Long,
    val title: String,
    val image: Int?,
    val description: String,
    val amount: Int,
)