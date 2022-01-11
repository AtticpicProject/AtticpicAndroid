package com.atticpic.myapplication.presentation.screen.login

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.atticpic.myapplication.databinding.FragmentLoginBinding
import com.atticpic.myapplication.presentation.base.AppState
import com.atticpic.myapplication.presentation.base.BaseViewModelBindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment :
    BaseViewModelBindingFragment<LoginViewModel, FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    override val fragmentViewModel: LoginViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDataFlows()
        initListeners()
    }

    private fun initListeners() {
        binding.buttonLogin.setOnClickListener {
            fragmentViewModel.userLogin(
                binding.inputEmail.text.toString(),
                binding.inputPassword.text.toString()
            )
        }
    }

    private fun initDataFlows() {
        lifecycleScope.launchWhenCreated {
            fragmentViewModel.uiState.collect { state ->
                when (state) {
                    AppState.Init -> {}
                    is AppState.Success -> {
                        Toast.makeText(requireContext(), state.data.token, Toast.LENGTH_SHORT)
                            .show()
                    }
                    is AppState.Error -> {
                        Toast.makeText(requireContext(), state.error.message, Toast.LENGTH_SHORT)
                            .show()
                    }
                    is AppState.Loading -> {}
                }
            }
        }
    }
}
