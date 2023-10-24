package com.slothdeboss.enefte.di

import com.slothdeboss.enefte.ui.screens.connectWallet.ConnectWalletScreenViewModel
import com.slothdeboss.enefte.ui.screens.home.HomeViewModel
import com.slothdeboss.enefte.ui.screens.onboarding.presentation.OnboardingViewModel
import com.slothdeboss.enefte.ui.screens.setupProfile.SetupProfileViewModel
import com.slothdeboss.enefte.ui.screens.start.StartScreenViewModel
import com.slothdeboss.enefte.ui.screens.welcome.WelcomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val ViewModelModule = module {
    viewModelOf(::SetupProfileViewModel)
    viewModelOf(::OnboardingViewModel)
    viewModelOf(::ConnectWalletScreenViewModel)
    viewModelOf(::HomeViewModel)
    viewModelOf(::StartScreenViewModel)
    viewModelOf(::WelcomeViewModel)
}
