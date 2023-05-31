package com.and.dev.homeservice.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.and.dev.homeservice.view.items.BottomBarItems
import com.and.dev.homeservice.view.screen.MoreScreen
import com.and.dev.homeservice.view.screen.OrdersScreen
import com.and.dev.homeservice.view.screen.ServiceScreen
import com.and.dev.homeservice.view.screen.UserScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarItems.Service.route
    ) {
        composable(route = BottomBarItems.Service.route) {
            ServiceScreen()

        }
        composable(route = BottomBarItems.Orders.route) {
            OrdersScreen()
        }
        composable(route = BottomBarItems.User.route) {
            UserScreen()
        }
        composable(route = BottomBarItems.More.route) {
            MoreScreen()
        }


    }
}