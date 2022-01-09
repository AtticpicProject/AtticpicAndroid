package com.atticpic.myapplication.presentation.screen.splash

import androidx.fragment.app.viewModels
import com.atticpic.myapplication.databinding.FragmentSplashBinding
import com.atticpic.myapplication.presentation.base.BaseBindingFragment

class SplashFragment :
    BaseBindingFragment<SplashViewModel, FragmentSplashBinding>(FragmentSplashBinding::inflate) {

    override val fragmentViewModel: SplashViewModel by viewModels()
}
