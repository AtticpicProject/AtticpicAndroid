package com.atticpic.myapplication.presentation.login

import androidx.fragment.app.viewModels
import com.atticpic.myapplication.databinding.FragmentLoginBinding
import com.atticpic.myapplication.presentation.BaseBindingFragment

class LoginFragment :
    BaseBindingFragment<LoginViewModel, FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    override val fragmentViewModel: LoginViewModel by viewModels()
}
