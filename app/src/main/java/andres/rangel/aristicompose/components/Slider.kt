package andres.rangel.aristicompose.components

import andres.rangel.aristicompose.ui.theme.AristiComposeTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.RangeSlider
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun ReviewSlider() {
    AristiComposeTheme {
        var show by rememberSaveable { mutableStateOf(false) }
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = { show = true }) {
                Text(text = "Mostrar dialogo")
            }
            MyCustomDialog(
                show = show,
                onDismiss = { show = false }
            )
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun MySlider() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var sliderPosition by remember { mutableStateOf(0f) }
        var completeValue by remember { mutableStateOf("") }
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            onValueChangeFinished = { completeValue = sliderPosition.toString() },
            valueRange = 1f..10f,
            steps = 8,
            enabled = true
        )
        Text(text = completeValue)

        Spacer(modifier = Modifier.height(20.dp))

        var sliderRange by remember { mutableStateOf(1f..6f) }
        var inferior by remember { mutableStateOf("") }
        var superior by remember { mutableStateOf("") }
        RangeSlider(
            values = sliderRange,
            onValueChange = { sliderRange = it },
            onValueChangeFinished = {
                inferior = sliderRange.start.toString()
                superior = sliderRange.endInclusive.toString()
            },
            valueRange = 1f..10f,
            steps = 8
        )
        Text(text = "Inferior $inferior")
        Text(text = "Superior $superior")
    }
}