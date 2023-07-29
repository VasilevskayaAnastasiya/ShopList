package com.example.shoplist.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
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

private const val GALLERY_REQUEST = 202
class AddItemFragment : Fragment() {
    private var _binding: FragmentAddItemBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ShoppingListViewModel by activityViewModels{
        ShoppingListViewModelFactory(
            (requireActivity().application as MyApp).ShoppingItemRepository
        )
    }

    lateinit var imagePickerActivityResult: ActivityResultLauncher<Intent>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddItemBinding.inflate(inflater, container, false)
        Log.d("TAG", "OnCreateViewAddItem: ${viewModel.toString()}")

        imagePickerActivityResult = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ){ result ->
            if(result != null){
                val imageUri = result.data?.data
                if(imageUri != null) {
                    viewModel.setImageUri(imageUri)
                }
            }
        }
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
                findNavController().popBackStack()
            }
            cancel.setOnClickListener{
                findNavController().popBackStack()
            }
            takePhotoImageView.setOnClickListener{
                getImageFromGallery()
            }
        }
        viewModel.lastImageUriData.value = null
        viewModel.lastImageUriData.observe(viewLifecycleOwner){ imageUri ->
            if(imageUri != null) {
                Glide.with(this)
                    .load(imageUri)
                    .into(binding.takePhotoImageView)
            }
        }
    }

    private fun getImageFromGallery(){
        val photoPickerIntent = Intent(Intent.ACTION_PICK)
        photoPickerIntent.type = "image/*"

        imagePickerActivityResult.launch(photoPickerIntent)
    }
    private fun createItemToAdd(): ShoppingItem?{

        return with(binding){
            val amount = amountEditText.text.toString().toIntOrNull() ?: 0
            if(amount == 0){
                return null
            }else {
                return ShoppingItem(
                    id = System.currentTimeMillis(),
                    title = titleEditText.text.toString(),
                    description = descriptionEditText.text.toString(),
                    amount = amount,
                    image = viewModel.lastImageUriData.value ?: null
                )
            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}