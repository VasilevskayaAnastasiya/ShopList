package com.example.shoplist.utils

import com.example.shoplist.adapters.ItemsListAdapter
import com.example.shoplist.data.ShoppingItem

fun ShoppingItem.getViewType(): Int {
    return if (image != null) {
        ItemsListAdapter.VIEW_TYPE_IMAGE_ITEM
    } else {
        ItemsListAdapter.VIEW_TYPE_TEXT_ITEM
    }
}