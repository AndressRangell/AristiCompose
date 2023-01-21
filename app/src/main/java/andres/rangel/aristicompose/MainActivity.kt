package andres.rangel.aristicompose

import andres.rangel.aristicompose.animations.VisibilityAnimation
import andres.rangel.aristicompose.ui.theme.AristiComposeTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi

@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AristiComposeTheme {
                VisibilityAnimation()
            }
        }
    }
}