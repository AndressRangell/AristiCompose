package andres.rangel.aristicompose.components

import andres.rangel.aristicompose.models.Routes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

//setup
/*val navController = rememberNavController()
NavHost(
navController = navController,
startDestination = Routes.ScreenOne.route
) {
    composable(Routes.ScreenOne.route) {
        ScreenOne(navController)
    }
    composable(Routes.ScreenTwo.route) {
        ScreenTwo(navController)
    }
    composable(Routes.ScreenThree.route) {
        ScreenThree(navController)
    }
    composable(Routes.ScreenFour.route) { backStackEntry ->
        ScreenFour(
            navController,
            backStackEntry.arguments?.getString("name").orEmpty()
        )
    }
    composable(
        Routes.ScreenFive.route,
        listOf(navArgument("age") {
            defaultValue = 0
            type = NavType.IntType
        })
    ) { backStackEntry ->
        ScreenFive(
            navController,
            backStackEntry.arguments?.getInt("age") ?: 0
        )
    }
}*/

@Composable
fun ScreenOne(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navController.navigate(Routes.ScreenTwo.route) },
            text = "Pantalla 1"
        )
    }
}

@Composable
fun ScreenTwo(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Magenta)
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navController.navigate(Routes.ScreenThree.route) },
            text = "Pantalla 2"
        )
    }
}

@Composable
fun ScreenThree(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.Center)
                .clickable {
                    navController.navigate(Routes.ScreenFour.createRoute("AndrésRangel"))
                },
            text = "Pantalla 3"
        )
    }
}

@Composable
fun ScreenFour(navController: NavHostController, name: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.Center)
                .clickable {
                    navController.navigate(Routes.ScreenFive.createRoute(24))
                },
            text = name
        )
    }
}

@Composable
fun ScreenFive(navController: NavHostController, age: Int) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.Center)
                .clickable {
                    navController.navigate(Routes.ScreenOne.route)
                },
            text = "Tengo $age años"
        )
    }
}