package com.example.jetpack11.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpack11.views.EmailView
import com.example.jetpack11.views.PhoneView
import com.example.jetpack11.views.SmsView

@Composable
fun NavManager(navHC:NavHostController){
    NavHost(navController = navHC, startDestination = Routes.PhoneView.route) {
        composable(Routes.PhoneView.route){
            PhoneView()
        }
        composable(Routes.SmsView.route){
            SmsView()
        }
        composable(Routes.EmailView.route){
            EmailView()
        }
    }
}