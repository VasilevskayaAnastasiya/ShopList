package com.example.shoplist

import android.os.Binder
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoplist.adapters.ItemsListAdapter
import com.example.shoplist.databinding.ActivityMainBinding
import com.example.shoplist.ui.theme.ShopListTheme
import com.example.shoplist.utils.Utils.dataSet

class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.adapter = ItemsListAdapter(dataSet)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

    }
}