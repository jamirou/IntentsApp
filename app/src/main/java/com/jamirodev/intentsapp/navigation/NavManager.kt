package com.jamirodev.intentsapp.navigation

import Routes
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jamirodev.intentsapp.views.EmailView
import com.jamirodev.intentsapp.views.PhoneView
import com.jamirodev.intentsapp.views.SmsView

@Composable
fun NavManager(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Routes.PhoneView.route) {
        composable(Routes.PhoneView.route) {
            PhoneView()
        }
        composable(Routes.SmsView.route) {
            SmsView()
        }
        composable(Routes.EmailView.route) {
            EmailView()
        }
    }
}