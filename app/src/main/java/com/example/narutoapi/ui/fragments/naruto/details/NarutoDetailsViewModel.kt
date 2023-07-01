package com.example.narutoapi.ui.fragments.naruto.details

import com.example.narutoapi.base.BaseViewModel
import com.example.narutoapi.data.repositories.NarutoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NarutoDetailsViewModel @Inject constructor(private val narutoRepository: NarutoRepository): BaseViewModel() {

    fun fetchCharacterSingle(id: Int) = narutoRepository.fetchCharacterSingle(id)
}