package agency.five.codebase.android.movieapp.component

import agency.five.codebase.android.movieapp.mock.MoviesMock
import agency.five.codebase.android.movieapp.model.Movie
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun MovieCard(modifier: Modifier,movie: Movie)
{
    Card(
        modifier = modifier.padding(15.dp).width(110.dp).height(200.dp).clickable {  },
        shape = RoundedCornerShape(20.dp),
        elevation = 5.dp
    ) {
        Box{
            AsyncImage(
                model = movie.imageUrl,
                contentDescription = movie.title,
                contentScale = ContentScale.Crop
            )
            FavoriteButton(modifier = Modifier
                .padding(1.dp)
                .size(30.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovieCardPreview(){
    val movie = MoviesMock.getMoviesList()[0]
    val movieCardModifier = Modifier
        .padding(5.dp)
        .width(140.dp)
        .height(200.dp)

    MovieCard(movie = movie, modifier = movieCardModifier)
}
