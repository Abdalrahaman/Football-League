package com.example.footballleague.utils

import androidx.navigation.NavDirections

sealed class NavigationCommand {

    data class To(val directions: NavDirections) : NavigationCommand()

    data object Back : NavigationCommand()

    data class BackTo(val destinationId: Int) : NavigationCommand()
}