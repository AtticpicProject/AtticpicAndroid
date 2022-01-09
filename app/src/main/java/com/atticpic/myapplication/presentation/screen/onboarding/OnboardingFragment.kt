package com.atticpic.myapplication.presentation.screen.onboarding

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.atticpic.myapplication.databinding.FragmentOnboardingBinding
import com.atticpic.myapplication.presentation.base.BaseBindingFragment

class OnboardingFragment :
    BaseBindingFragment<FragmentOnboardingBinding>(FragmentOnboardingBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonOnboarding.setOnClickListener {
            val action =
                OnboardingFragmentDirections.actionOnboardingFragmentToLoginFragment(userName = "username")
            findNavController().navigate(action)
        }
    }
}
