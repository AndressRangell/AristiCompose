package andres.rangel.aristicompose.models

sealed class Routes(val route: String) {

    object ScreenOne : Routes("ScreenOne")

    object ScreenTwo : Routes("ScreenTwo")

    object ScreenThree : Routes("ScreenThree")

    object ScreenFour : Routes("ScreenFour/{name}") { // Mandatory parameters
        fun createRoute(name: String) = "ScreenFour/$name"
    }

    object ScreenFive : Routes("ScreenFive?age={age}") { // Optional parameters
        fun createRoute(age: Int) = "ScreenFive?age=$age"
    }

}