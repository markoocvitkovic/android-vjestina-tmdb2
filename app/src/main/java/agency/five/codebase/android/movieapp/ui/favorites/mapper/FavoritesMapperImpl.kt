package agency.five.codebase.android.movieapp.ui.favorites.mapper

import agency.five.codebase.android.movieapp.model.Movie
import agency.five.codebase.android.movieapp.ui.component.MovieCardViewState
import agency.five.codebase.android.movieapp.ui.favorites.FavoritesMovieViewState
import agency.five.codebase.android.movieapp.ui.favorites.FavoritesViewState

class FavoritesMapperImpl : FavoritesMapper {
    override fun toFavoritesViewState(favoriteMovies: List<Movie>): FavoritesViewState {

        val favoriteMoviesViewStates = favoriteMovies.map {
            mapMovie(it)
        }

        return FavoritesViewState(favoriteMoviesViewStates)
    }

    private fun mapMovie(movie: Movie) = FavoritesMovieViewState(
        id = movie.id,
        movieCardViewState = MovieCardViewState(
            id = movie.id,
            imageUrl = movie.imageUrl,
            isFavorite = movie.isFavorite,
            title = movie.title
        )
    )
}

