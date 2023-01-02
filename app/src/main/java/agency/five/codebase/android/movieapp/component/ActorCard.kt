package agency.five.codebase.android.movieapp.component

import agency.five.codebase.android.movieapp.mock.MoviesMock
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

data class ActorCardViewState(
    val imageUrl: String?,
    val name: String,
    val character: String
)

@Composable
fun ActorCard(actorCardViewState: ActorCardViewState, modifier: Modifier) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(20.dp),
        elevation = 10.dp
    ) {
        Column {
            AsyncImage(
                model = actorCardViewState.imageUrl,
                contentDescription = actorCardViewState.name,
                modifier = Modifier
                    .weight(0.8F),
                contentScale = ContentScale.Crop
            )
            Text(
                modifier = Modifier
                    .padding(top = 10.dp),
                text = actorCardViewState.name,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
            Text(
                modifier = Modifier
                    .padding(start = 5.dp, top = 5.dp, bottom = 5.dp),
                text = actorCardViewState.character,
                color = Color.Gray,
                fontSize = 10.sp

            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ActorCardPreview() {
    val actor = MoviesMock.getActor()
    val actorCardViewState = ActorCardViewState(
        name = actor.name,
        imageUrl = actor.imageUrl,
        character = actor.character
    )

    val actorCardModifier = Modifier
        .height(230.dp)
        .width(140.dp)
        .padding(5.dp)

    ActorCard(actorCardViewState = actorCardViewState, modifier = actorCardModifier)
}
