package com.example.shoplist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.shoplist.MyApp
import com.example.shoplist.R
import com.example.shoplist.data.ShoppingItem
import com.example.shoplist.databinding.FragmentAddItemBinding
import com.example.shoplist.domain.ShoppingListViewModel
import com.example.shoplist.domain.ShoppingListViewModelFactory

/**
 * A simple [Fragment] subclass.
 * Use the [AddItemFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddItemFragment : Fragment() {
    private var _binding: FragmentAddItemBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ShoppingListViewModel by viewModels{
        ShoppingListViewModelFactory(
            (requireActivity().application as MyApp).ShoppingItemRepository
        )
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
    }

    private fun setUpViews(){
        with(binding){
            submit.setOnClickListener{
                val itemToAdd = createItemToAdd()
                if(itemToAdd != null){
                    viewModel.addItem(itemToAdd)
                }
            }
        }
    }

    private fun createItemToAdd(): ShoppingItem?{
        return with(binding){
            ShoppingItem(
                id = System.currentTimeMillis(),
                title = titleEditText.text.toString(),
                description = descriptionEditText.text.toString(),
                amount = amountEditText.text.toString().toInt(),
                image = null
            )
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}