package com.example.narutoapi.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB: ViewBinding, VM: BaseViewModel>(@LayoutRes layoutId: Int)
    : Fragment(layoutId) {

    protected abstract val binding:VB
    protected abstract val viewModel:VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialization()
        setupView()
        setupListener()
        setupRequest()
        setupObserves()
    }

    protected open fun initialization() {}

    protected open fun setupView() {}

    protected open fun setupListener() {}

    protected open fun setupRequest() {}

    protected open fun setupObserves() {}
}