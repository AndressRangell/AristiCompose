package andres.rangel.aristicompose.components

import andres.rangel.aristicompose.ui.theme.AristiComposeTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun ReviewRadioButton() {
    AristiComposeTheme {
        var selected by rememberSaveable { mutableStateOf("Juan") }
        Column {
            MyRadioButton(name = selected) {
                selected = it
            }
        }
    }
}

@Composable
fun MyRadioButton(name: String, onItemSelected: (String) -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row {
            RadioButton(
                selected = name == "Juan",
                onClick = { onItemSelected("Juan") }
            )
            Text(
                text = "Juan",
                modifier = Modifier.padding(top = 10.dp)
            )
        }
        Row {
            RadioButton(
                selected = name == "Pedro",
                onClick = { onItemSelected("Pedro") }
            )
            Text(
                text = "Pedro",
                modifier = Modifier.padding(top = 10.dp)
            )
        }
        Row {
            RadioButton(
                selected = name == "Lucas",
                onClick = { onItemSelected("Lucas") }
            )
            Text(
                text = "Lucas",
                modifier = Modifier.padding(top = 10.dp)
            )
        }
    }
}