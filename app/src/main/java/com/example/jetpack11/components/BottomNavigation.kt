package com.example.jetpack11.components

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.jetpack11.navigation.Routes

@Composable
fun currentRoute(navHostController: NavHostController):String?{
    val current by navHostController.currentBackStackEntryAsState()
    return current?.destination?.route
}

@Composable
fun BottonNav(navHostController: NavHostController,routes:List<Routes>){
    BottomAppBar {
        NavigationBar (containerColor = Color.White){
            val current = currentRoute(navHostController = navHostController)
            routes.forEach {item->
                NavigationBarItem(selected = current == item.route, onClick = {navHostController.navigate(item.route)}, icon = {
                    Icon(imageVector = item.icon, contentDescription = item.title,tint = Color.Blue) },
                    label = {Text(text= item.title)},alwaysShowLabel = false)
            }
        }
    }
}
