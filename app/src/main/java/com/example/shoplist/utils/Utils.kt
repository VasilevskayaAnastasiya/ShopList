package com.example.shoplist.utils

import com.example.shoplist.R
import com.example.shoplist.data.ShoppingItem

object Utils {

    val dataSet = arrayListOf(
        ShoppingItem(
            id = 0,
            image = R.drawable.no_image_placeholder,
            title = "My title 1",
            description = "My Content 1",
            amount = 0
        ),
        ShoppingItem(
            id = 1,
            image = null,
            title = "My title 2",
            description = "My Content 2",
            amount = 0
        ),
        ShoppingItem(
            id = 2,
            image = R.drawable.no_image_placeholder,
            title = "My title 3",
            description = "My Content 3",
            amount = 0
        ),
        ShoppingItem(
            id = 3,
            image = null,
            title = "My title 4",
            description = "My Content 4",
            amount = 0
        )
    )
}