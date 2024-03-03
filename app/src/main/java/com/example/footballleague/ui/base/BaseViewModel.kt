package com.example.footballleague.ui.base

import androidx.lifecycle.ViewModel
import com.example.footballleague.utils.NavigationCommand
import com.example.footballleague.utils.SingleLiveEvent

abstract class BaseViewModel : ViewModel() {

    val navigationCommand: SingleLiveEvent<NavigationCommand> = SingleLiveEvent()
    val showToast: SingleLiveEvent<String> = SingleLiveEvent()
    val showLoading: SingleLiveEvent<Boolean> = SingleLiveEvent()
}