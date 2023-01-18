package andres.rangel.aristicompose.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyTextField() {
    var myText by remember { mutableStateOf("") }
    var myOutlineText by remember { mutableStateOf("") }
    Column {
        TextField(
            value = myText,
            onValueChange = {
                myText = if (it.contains("a")) {
                    it.replace("a", "@")
                } else {
                    it
                }
            },
            label = {
                Text(text = "Introduce un texto")
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = myOutlineText,
            onValueChange = { myOutlineText = it },
            label = { Text(text = "Introduce otro texto") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Magenta,
                unfocusedBorderColor = Color.Blue
            )
        )
    }
}