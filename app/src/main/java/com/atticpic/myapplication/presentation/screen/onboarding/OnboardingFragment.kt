package com.atticpic.myapplication.presentation.screen.onboarding

import androidx.fragment.app.viewModels
import com.atticpic.myapplication.databinding.FragmentOnboardingBinding
import com.atticpic.myapplication.presentation.base.BaseBindingFragment

class OnboardingFragment :
    BaseBindingFragment<OnboardingViewModel, FragmentOnboardingBinding>(FragmentOnboardingBinding::inflate) {

    override val fragmentViewModel: OnboardingViewModel by viewModels()
}
