package com.example.burgersapp.presenter.burgers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.burgersapp.databinding.FragmentBurgersBinding
import com.example.burgersapp.domain.model.Burger
import com.example.burgersapp.util.StateView
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class BurgersFragment : Fragment() {

    private var _binding: FragmentBurgersBinding? = null
    private val binding get() = _binding!!

    private val viewModel: BurgerViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBurgersBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getBurgers()
        initListeners()
    }

    private fun initListeners() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener
        {
            override fun onQueryTextSubmit(nome: String?): Boolean {
                return if(nome != null){
                    getBurgersByName(nome)
                    true
                }else false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })

        val closeButton: View? = binding.searchView.findViewById(androidx.appcompat.R.id.search_close_btn)
        closeButton?.setOnClickListener {
            binding.searchView.setQuery("", false)
            binding.searchView.clearFocus()
            getBurgers()
        }
    }

    private fun getBurgers() {
        viewModel.getBurgers().observe(viewLifecycleOwner) { stateview ->
            when(stateview) {
                is StateView.Loading -> {
                    binding.rvBurgers.isVisible = false
                    binding.progressBar.isVisible = true
                }
                is StateView.Error -> {
                    binding.progressBar.isVisible = false
                    binding.rvBurgers.isVisible = true
                    Toast.makeText(requireContext(), stateview.message, Toast.LENGTH_SHORT).show()
                }
                is StateView.Success -> {
                    binding.progressBar.isVisible = false
                    binding.rvBurgers.isVisible = true
                    initRecycler(stateview.data?: emptyList())
                }
            }
        }
    }

    private fun getBurgersByName(name: String) {
        viewModel.getBurgersByName(name).observe(viewLifecycleOwner) { stateview ->
            when(stateview) {
                is StateView.Loading -> {
                    binding.rvBurgers.isVisible = false
                    binding.progressBar.isVisible = true
                }
                is StateView.Error -> {
                    binding.progressBar.isVisible = false
                    binding.rvBurgers.isVisible = true
                    Toast.makeText(requireContext(), stateview.message, Toast.LENGTH_SHORT).show()
                }
                is StateView.Success -> {

                    binding.progressBar.isVisible = false
                    binding.rvBurgers.isVisible = true
                    initRecycler(stateview.data?: emptyList())
                }
            }
        }
    }

    private fun initRecycler(burgers : List<Burger>) {
        with(binding.rvBurgers) {
            setHasFixedSize(true)
            adapter = BurgersAdapter(burgers) { burgerId ->
                val action = BurgersFragmentDirections
                    .actionBurgersFragmentToDetailsFragment(burgerId)
                findNavController().navigate(action)
            }
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}