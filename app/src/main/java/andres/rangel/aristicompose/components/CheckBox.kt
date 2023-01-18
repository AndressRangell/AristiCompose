package andres.rangel.aristicompose.components

import andres.rangel.aristicompose.models.CheckInfo
import andres.rangel.aristicompose.models.CheckTriStateInfo
import andres.rangel.aristicompose.ui.theme.AristiComposeTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Text
import androidx.compose.material.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun ReviewCheckBox() {
    AristiComposeTheme {
        val myOptions = getOptions(listOf("Juan", "Pedro", "Lucas"))
        Column {
            myOptions.forEach {
                MyCheckBox(it)
            }
        }
    }
}

@Composable
fun getTriStateOptions(titles: List<String>): List<CheckTriStateInfo> {
    return titles.map {
        var state by rememberSaveable { mutableStateOf(ToggleableState.Off) }
        CheckTriStateInfo(
            title = it,
            state = state,
            onCheckedChange = { myNewState ->
                state = myNewState
            }
        )
    }
}

@Composable
fun MyCheckBoxTriState(checkInfo: CheckTriStateInfo) {
    Row(
        modifier = Modifier.padding(8.dp)
    ) {
        TriStateCheckbox(
            state = checkInfo.state,
            onClick = {
                checkInfo.onCheckedChange(
                    when (checkInfo.state) {
                        ToggleableState.On -> ToggleableState.Indeterminate
                        ToggleableState.Off -> ToggleableState.On
                        ToggleableState.Indeterminate -> ToggleableState.Off
                    }
                )
            },
            enabled = true,
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Magenta,
                uncheckedColor = Color.Green,
                checkmarkColor = Color.White
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = checkInfo.title,
            modifier = Modifier.padding(top = 10.dp)
        )
    }
}

@Composable
fun getOptions(titles: List<String>): List<CheckInfo> {
    return titles.map {
        var state by rememberSaveable { mutableStateOf(false) }
        CheckInfo(
            title = it,
            selected = state,
            onCheckedChange = { myNewState ->
                state = myNewState
            }
        )
    }
}

@Composable
fun MyCheckBox(checkInfo: CheckInfo) {
    Row(
        modifier = Modifier.padding(8.dp)
    ) {
        Checkbox(
            checked = checkInfo.selected,
            onCheckedChange = {
                checkInfo.onCheckedChange(!checkInfo.selected)
            },
            enabled = true,
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Magenta,
                uncheckedColor = Color.Green,
                checkmarkColor = Color.White
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = checkInfo.title,
            modifier = Modifier.padding(top = 10.dp)
        )
    }
}