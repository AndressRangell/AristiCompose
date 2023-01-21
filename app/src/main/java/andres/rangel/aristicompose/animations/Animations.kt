package andres.rangel.aristicompose.animations

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ColorAnimation() {
    Column {
        var firstColor by rememberSaveable { mutableStateOf(false) }
        var showBox by rememberSaveable { mutableStateOf(true) }
        val realColor = animateColorAsState(
            targetValue = if (firstColor) Color.Red else Color.Yellow,
            animationSpec = tween(3000),
            finishedListener = { showBox = false }
        )
        if (showBox) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(realColor.value)
                    .clickable { firstColor = !firstColor }
            )
        }
    }
}

@Composable
fun SizeAnimation() {
    var smallSize by rememberSaveable { mutableStateOf(true) }
    val size by animateDpAsState(
        targetValue = if (smallSize) 50.dp else 100.dp,
        animationSpec = tween(1000),
        finishedListener = {
            smallSize = !smallSize
        }
    )
    Box(modifier = Modifier
        .size(size)
        .background(Color.Cyan)
        .clickable { smallSize = !smallSize }
    )
}

@Composable
fun VisibilityAnimation() {
    var isVisible by remember { mutableStateOf(true) }
    Column(modifier = Modifier.fillMaxSize()) {
        Button(onClick = { isVisible = !isVisible }) {
            Text(text = "Lanzar animación")
        }
        Spacer(modifier = Modifier.size(50.dp))
        AnimatedVisibility(
            visible = isVisible,
            enter = slideInHorizontally(),
            exit = slideOutHorizontally()
        ) {
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .background(Color.Red)
            )
        }
    }
}