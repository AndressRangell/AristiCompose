package andres.rangel.aristicompose.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyButton() {
    var enabled by rememberSaveable { mutableStateOf(true) }
    Column(
        modifier = Modifier.padding(24.dp)
    ) {
        Button(
            onClick = { enabled = !enabled },
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta,
                contentColor = Color.Blue
            ),
            border = BorderStroke(
                3.dp,
                Color.Green
            )
        ) {
            Text(text = "Button")
        }
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedButton(
            onClick = { enabled = !enabled },
            enabled = !enabled,
            colors = ButtonDefaults.buttonColors(
                disabledBackgroundColor = Color.Magenta,
                disabledContentColor = Color.Blue
            ),
        ) {
            Text(text = "OutlineButton")
        }
    }
}