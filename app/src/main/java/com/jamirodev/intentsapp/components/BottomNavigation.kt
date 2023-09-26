package com.jamirodev.intentsapp.components

import Routes
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


@Composable
fun BottomNav(navHostController: NavHostController, routes: List<Routes>) {
    BottomAppBar {
        NavigationBar(
            containerColor = Color.White
        ) {
            val currentRoute = currentRoute(navHostController)
            routes.forEach { item ->
                NavigationBarItem(
                    selected = currentRoute == item.route,
                    onClick = { navHostController.navigate(item.route) },
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title,
                            tint = Color.DarkGray
                        )
                    },
                    label = {
                        Text(text = item.title)
                    },
                    alwaysShowLabel = true
                )
            }
        }
    }
}

@Composable
fun currentRoute(navHostController: NavHostController): String? {
    val current by navHostController.currentBackStackEntryAsState()
    return current?.destination?.route
}