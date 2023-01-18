package andres.rangel.aristicompose.components

import andres.rangel.aristicompose.R
import andres.rangel.aristicompose.ui.theme.AristiComposeTheme
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Preview
@Composable
fun ReviewDialog() {
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

@Composable
fun MyCustomDialog(show: Boolean, onDismiss: () -> Unit) {
    if (show) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier.padding(bottom = 12.dp),
                    text = "Set backup account",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp
                )
                AccountItem(
                    email = "andres.rangel555@gmail.com",
                    drawable = R.drawable.ic_launcher_background
                )
                AccountItem(
                    email = "andres.rangel@mercadolibre.com.co",
                    drawable = R.drawable.ic_launcher_background
                )
                AccountItem(
                    email = "andresfrangel@uts.edu.co",
                    drawable = R.drawable.ic_launcher_background
                )
            }
        }
    }
}

@Composable
fun AccountItem(email: String, @DrawableRes drawable: Int) {
    Row(
        modifier = Modifier.clickable { },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape)
        )
        Text(
            modifier = Modifier.padding(8.dp),
            text = email,
            fontSize = 14.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun MyDialog(show: Boolean, onConfirm: () -> Unit, onDismiss: () -> Unit) {
    if (show) {
        AlertDialog(
            onDismissRequest = { onDismiss() },
            title = { Text(text = "Título de alerta!!") },
            text = { Text(text = "Descripción de alerta!!") },
            confirmButton = {
                TextButton(
                    onClick = { onConfirm() }
                ) {
                    Text(text = "Aceptar")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { onDismiss() }
                ) {
                    Text(text = "Cancelar")
                }
            }
        )
    }
}