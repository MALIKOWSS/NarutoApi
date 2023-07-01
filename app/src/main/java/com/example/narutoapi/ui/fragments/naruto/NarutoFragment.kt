package com.example.narutoapi.ui.fragments.naruto

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.narutoapi.base.BaseFragment
import com.example.narutoapi.ui.adapters.naruto.NarutoAdapter
import com.example.narutoapi.utils.Resource
import com.example.rickandmortyapi.R
import com.example.rickandmortyapi.databinding.FragmentNarutoBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NarutoFragment
    : BaseFragment<FragmentNarutoBinding, NarutoViewModel>(R.layout.fragment_naruto) {

    override val binding by viewBinding(FragmentNarutoBinding::bind)
    override val viewModel: NarutoViewModel by viewModels()
    private val narutoAdapter = NarutoAdapter(this::onClickItem)

    override fun initialization() {
        binding.rvNaruto.apply {
            adapter = narutoAdapter
        }
    }

    override fun setupObserves() {
        viewModel.fetchCharacter().observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                when (it) {
                    is Resource.Error -> {
                        Log.e("Error", it.message.toString())
                    }

                    is Resource.Loading -> {
                        Log.e("Loading", it.message.toString())
                    }

                    is Resource.Success -> {
                        it.data.let {
                            narutoAdapter.submitList(it?.characters)
                        }
                    }
                }
            }
        }
    }

    private fun onClickItem(id: String) {
        findNavController().navigate(
            NarutoFragmentDirections.actionNarutoFragmentToNarutoDetailsFragment(
                id.toInt()
            )
        )
    }
}