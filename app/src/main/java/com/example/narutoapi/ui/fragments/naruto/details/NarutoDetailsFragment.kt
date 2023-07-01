package com.example.narutoapi.ui.fragments.naruto.details

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import com.example.narutoapi.base.BaseFragment
import com.example.narutoapi.utils.Resource
import com.example.rickandmortyapi.R
import com.example.rickandmortyapi.databinding.FragmentNarutoDetailsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NarutoDetailsFragment :
    BaseFragment<FragmentNarutoDetailsBinding, NarutoDetailsViewModel>(R.layout.fragment_naruto_details) {

    override val binding: FragmentNarutoDetailsBinding by viewBinding(FragmentNarutoDetailsBinding::bind)
    override val viewModel: NarutoDetailsViewModel by viewModels()
    private val navArgs by navArgs<NarutoDetailsFragmentArgs>()

    override fun setupObserves() {
        viewModel.fetchCharacterSingle(navArgs.id).observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                when (it) {
                    is Resource.Error -> {
                        Log.e("Error", it.message.toString())
                    }

                    is Resource.Loading -> {
                        Log.e("Loading", it.message.toString())
                    }

                    is Resource.Success -> {
                        Log.e("Loading", it.data.toString())
                        it.data.let {
                            binding.name.text = it?.name
                            if (it?.images?.isEmpty() == false) {
                                binding.image.load(it.images[0])
                            }
                        }
                    }
                }
            }
        }
    }
}