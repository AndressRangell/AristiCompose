package andres.rangel.aristicompose

import andres.rangel.aristicompose.models.SuperHero
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Composable
fun SuperHeroView() {
    val context = LocalContext.current
    LazyColumn {
        items(getSuperHeroes()) { superHero ->
            ItemHero(superHero) {
                Toast.makeText(context, it.superHeroName, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SuperHeroGridView() {
    val context = LocalContext.current
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        contentPadding = PaddingValues(
            horizontal = 16.dp,
            vertical = 8.dp
        ),
        content = {
            items(getSuperHeroes()) { superHero ->
                ItemHero(superHero) {
                    Toast.makeText(context, it.superHeroName, Toast.LENGTH_SHORT).show()
                }
            }
        }
    )
}

@Composable
fun SuperHeroWithSpecialControlsView() {
    val context = LocalContext.current
    val recyclerState = rememberLazyListState()
    val coroutinesScope = rememberCoroutineScope()
    val showButton by remember {
        derivedStateOf { recyclerState.firstVisibleItemIndex > 1 }
    }
    Column {
        LazyColumn(
            modifier = Modifier.weight(1f),
            state = recyclerState,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(getSuperHeroes()) { superHero ->
                ItemHero(superHero) {
                    Toast.makeText(context, it.superHeroName, Toast.LENGTH_SHORT).show()
                }
            }
        }
        if (showButton) {
            Button(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp),
                onClick = {
                    coroutinesScope.launch {
                        recyclerState.animateScrollToItem(0)
                    }
                }
            ) {
                Text(text = "Botón")
            }
        }
    }
}

@Composable
fun ItemHero(superHero: SuperHero, onItemSelected: (SuperHero) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemSelected(superHero) },
        border = BorderStroke(2.dp, Color.Red)
    ) {
        Column {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                painter = painterResource(id = superHero.photo),
                contentDescription = "SuperHero",
                contentScale = ContentScale.Crop
            )
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = superHero.superHeroName
            )
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = superHero.realName,
                fontSize = 12.sp
            )
            Text(
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.End),
                text = superHero.publisher,
                fontSize = 10.sp
            )
        }
    }
}

fun getSuperHeroes(): List<SuperHero> {
    return listOf(
        SuperHero(
            "Black Widow",
            "Natasha Romanof",
            "Marvel",
            R.drawable.black_widow
        ),
        SuperHero(
            "Ojo de halcón",
            "Clint Barton",
            "Marvel",
            R.drawable.clin_barton
        ),
        SuperHero(
            "Hulk",
            "Bruce Banner",
            "Marvel",
            R.drawable.hulk
        ),
        SuperHero(
            "Capitán América",
            "Steve Rogers",
            "Marvel",
            R.drawable.capitan_america
        ),
        SuperHero(
            "Thor",
            "Thor Odinson",
            "Marvel",
            R.drawable.thor
        ),
        SuperHero(
            "Ironman",
            "Tony Stark",
            "Marvel",
            R.drawable.ironman
        )
    )
}