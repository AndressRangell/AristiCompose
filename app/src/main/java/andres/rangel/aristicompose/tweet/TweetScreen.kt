package andres.rangel.aristicompose.tweet

import andres.rangel.aristicompose.R
import andres.rangel.aristicompose.ui.theme.Background
import andres.rangel.aristicompose.ui.theme.IconGreen
import andres.rangel.aristicompose.ui.theme.IconRed
import andres.rangel.aristicompose.ui.theme.Shapes
import andres.rangel.aristicompose.ui.theme.TextGray
import andres.rangel.aristicompose.ui.theme.TextWhite
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

const val TEXT = "Descripción id w arga sobre dwd texto Descripción larga sobre texto Descripción" +
        " larga sobre texto Descripción larga sobre texto Descripción larga dw dadsobre texto"

@Composable
fun TweetScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            ProfileImage(modifier = Modifier.weight(0.15f))
            ContentTweet(modifier = Modifier.weight(0.85f))
        }
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp),
            color = TextGray,
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            ProfileImage(modifier = Modifier.weight(0.15f))
            ContentTweet(modifier = Modifier.weight(0.85f))
        }
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp),
            color = TextGray,
        )
    }
}

@Composable
fun ContentTweet(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        ContentHeader()
        ContentMessage()
        ContentFooter()
    }
}

@Composable
fun ContentFooter() {
    var chatState by remember { mutableStateOf(false) }
    var retreatState by remember { mutableStateOf(false) }
    var favoriteState by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 50.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            Icon(
                modifier = Modifier
                    .padding(end = 4.dp)
                    .size(18.dp)
                    .clickable { chatState = !chatState },
                painter = if (chatState) {
                    painterResource(id = R.drawable.chat_filled)
                } else {
                    painterResource(id = R.drawable.chat)
                },
                contentDescription = "Icon chat",
                tint = TextGray
            )
            Text(
                text = if (chatState) "2" else "1",
                color = TextGray
            )
        }
        Row {
            Icon(
                modifier = Modifier
                    .padding(end = 4.dp)
                    .size(18.dp)
                    .clickable { retreatState = !retreatState },
                painter = painterResource(id = R.drawable.rt),
                contentDescription = "Icon retreat",
                tint = if (retreatState) IconGreen else TextGray
            )
            Text(
                text = if (retreatState) "3" else "2",
                color = TextGray
            )
        }
        Row {
            Icon(
                modifier = Modifier
                    .padding(end = 4.dp)
                    .size(18.dp)
                    .clickable { favoriteState = !favoriteState },
                painter = if (favoriteState) {
                    painterResource(id = R.drawable.favorite_filled)
                } else {
                    painterResource(id = R.drawable.favorite)
                },
                contentDescription = "Icon favorite",
                tint = if (favoriteState) IconRed else TextGray
            )
            Text(
                text = if (favoriteState) "6" else "5",
                color = TextGray
            )
        }
        Row {
            Icon(
                modifier = Modifier
                    .size(18.dp)
                    .clickable { },
                painter = painterResource(id = R.drawable.share),
                contentDescription = "Icon share",
                tint = TextGray
            )
        }
    }
}

@Composable
fun ContentMessage() {
    Text(
        modifier = Modifier.padding(bottom = 16.dp, end = 8.dp),
        text = TEXT,
        color = TextWhite
    )
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
            .padding(bottom = 16.dp)
            .clip(Shapes.small),
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "Imagen del tweet",
        contentScale = ContentScale.Crop
    )
}

@Composable
fun ContentHeader() {
    Row(
        modifier = Modifier.padding(bottom = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .weight(0.9f)
        ) {
            Text(
                modifier = Modifier.padding(end = 8.dp),
                text = "Aris",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.padding(end = 8.dp),
                text = "@AristiDevs",
                color = TextGray,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "4h",
                modifier = Modifier,
                color = TextGray,
                fontWeight = FontWeight.Bold
            )
        }
        Icon(
            modifier = Modifier
                .size(20.dp)
                .align(Alignment.CenterVertically)
                .weight(0.1f),
            tint = Color.White,
            painter = painterResource(id = R.drawable.more),
            contentDescription = "Icon more"
        )
    }
}

@Composable
fun ProfileImage(modifier: Modifier) {
    Image(
        modifier = modifier.clip(CircleShape),
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "Profile image"
    )
}
