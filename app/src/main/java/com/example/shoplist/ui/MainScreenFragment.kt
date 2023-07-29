package com.example.shoplist.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoplist.MyApp
import com.example.shoplist.R
import com.example.shoplist.adapters.ItemsListAdapter
import com.example.shoplist.databinding.MainScreenFragmentBinding
import com.example.shoplist.domain.ShoppingListViewModel
import com.example.shoplist.domain.ShoppingListViewModelFactory
import com.example.shoplist.utils.Utils

class MainScreenFragment : Fragment() {

    private var _binding: MainScreenFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ShoppingListViewModel by activityViewModels{
        ShoppingListViewModelFactory(
            (requireActivity().application as MyApp).ShoppingItemRepository
        )
    }

    var mainRecyclerViewAdapter: ItemsListAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MainScreenFragmentBinding.inflate(inflater, container, false)
        Log.d("TAG", "OnCreateViewMain: ${viewModel.toString()}")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViews()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setupViews(){
         mainRecyclerViewAdapter = ItemsListAdapter(
             context = requireContext(),
            list = viewModel.getAll(),
            increaseItemAmountInStorage = { item ->
                viewModel.updateItem(item)
            },
            decreaseItemAmountInStorage = { item ->
                viewModel.updateItem(item)
            }
        )
        binding.recyclerView.adapter = mainRecyclerViewAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        binding.addItemButton.setOnClickListener{
            findNavController().navigate(R.id.action_mainScreenFragment_to_addItemFragment)
        }

        viewModel.databaseData.observe(viewLifecycleOwner){dataset ->
            mainRecyclerViewAdapter?.setNewDataset(dataset)
        }
    }
}