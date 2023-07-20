package com.example.shoplist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoplist.R
import com.example.shoplist.adapters.ItemsListAdapter
import com.example.shoplist.databinding.MainScreenFragmentBinding
import com.example.shoplist.utils.Utils

class MainScreenFragment : Fragment() {

    private var _binding: MainScreenFragmentBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MainScreenFragmentBinding.inflate(inflater, container, false)
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
        binding.recyclerView.adapter = ItemsListAdapter(Utils.dataSet)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        binding.addItemButton.setOnClickListener{
            findNavController().navigate(R.id.action_mainScreenFragment_to_addItemFragment)
        }
    }
}