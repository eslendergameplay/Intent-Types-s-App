package com.example.jetpack11.views

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpack11.components.BottonNav
import com.example.jetpack11.navigation.NavManager
import com.example.jetpack11.navigation.Routes

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView(){
    val navC = rememberNavController()
    val navigationRoutes = listOf(
        Routes.PhoneView,Routes.SmsView,Routes.EmailView
    )

    Scaffold (bottomBar = { BottonNav(navHostController = navC, routes = navigationRoutes)}){
        NavManager(navHC = navC)
    }
}