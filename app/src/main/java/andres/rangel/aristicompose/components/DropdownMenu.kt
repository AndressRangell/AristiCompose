package andres.rangel.aristicompose.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyDropdownMenu() {
    var selectedText by rememberSaveable { mutableStateOf("Seleccione un nombre") }
    var expanded by rememberSaveable { mutableStateOf(false) }
    val desserts = listOf("Juan", "Pedro", "Lucas")

    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        OutlinedTextField(
            modifier = Modifier
                .clickable { expanded = true }
                .fillMaxWidth(),
            value = selectedText,
            onValueChange = { selectedText = it },
            enabled = false,
            readOnly = true
        )
        DropdownMenu(
            modifier = Modifier.fillMaxWidth(),
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            desserts.forEach { dessert ->
                DropdownMenuItem(
                    onClick = {
                        expanded = false
                        selectedText = dessert
                    }
                ) {
                    Text(text = dessert)
                }
            }
        }
    }
}