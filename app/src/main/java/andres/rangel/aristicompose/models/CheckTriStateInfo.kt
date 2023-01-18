package andres.rangel.aristicompose.models

import androidx.compose.ui.state.ToggleableState

data class CheckTriStateInfo(
    val title: String,
    var state: ToggleableState = ToggleableState.Off,
    var onCheckedChange: (ToggleableState) -> Unit
)