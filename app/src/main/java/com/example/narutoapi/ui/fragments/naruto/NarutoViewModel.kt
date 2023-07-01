package com.example.narutoapi.ui.fragments.naruto

import com.example.narutoapi.base.BaseViewModel
import com.example.narutoapi.data.repositories.NarutoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NarutoViewModel @Inject constructor(private val narutoRepository: NarutoRepository) :
    BaseViewModel() {

    fun fetchCharacter() = narutoRepository.fetchCharacter()
}