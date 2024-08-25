package com.example.burgersapp.presenter.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.burgersapp.databinding.FragmentDetailsBinding
import com.example.burgersapp.domain.model.Burger
import com.example.burgersapp.domain.model.Ingredient
import com.example.burgersapp.util.StateView
import com.example.burgersapp.util.formattedValue
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val args: DetailsFragmentArgs by navArgs()
    private val viewModel: DetailsViewModel by viewModels()
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getBurgerById()
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun getBurgerById() {
        viewModel.getBurgersById(args.burgerId).observe(viewLifecycleOwner) { stateview ->
            when(stateview) {
                is StateView.Loading -> {
                }
                is StateView.Error -> {
                    Toast.makeText(requireContext(), stateview.message, Toast.LENGTH_SHORT).show()
                }
                is StateView.Success -> {
                    stateview.data?.let {
                        configData(it)
                    }

                }
            }
        }
    }

    private fun configData(burger: Burger) {
        Picasso
            .get()
            .load(burger.image?.get(1)?.lg)
            .into(binding.burgerImage)

        binding.burgerTitle.text = burger.name
        binding.burgerDesc.text = burger.desc
        binding.burgerPrice.text = burger.price?.formattedValue()
        initRecyclerView(burger.ingredient ?: emptyList())

    }

    private fun initRecyclerView(ingredients: List<Ingredient>) {
        with(binding.rvIngredients) {
            setHasFixedSize(true)
            adapter = IngredientsAdapter(ingredients)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}