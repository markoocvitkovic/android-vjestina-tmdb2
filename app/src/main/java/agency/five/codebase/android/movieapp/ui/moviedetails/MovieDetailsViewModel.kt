package agency.five.codebase.android.movieapp.ui.moviedetails

import agency.five.codebase.android.movieapp.data.repository.MovieRepository
import agency.five.codebase.android.movieapp.mock.MoviesMock
import agency.five.codebase.android.movieapp.ui.moviedetails.mapper.MovieDetailsMapper
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MovieDetailsViewModel(
    private val movieRepository: MovieRepository,
    private val movieDetailsMapper: MovieDetailsMapper,
    private val movieId: Int
) : ViewModel() {
    val movieDetailViewState: StateFlow<MovieDetailsViewState> =
        movieRepository.movieDetails(movieId).map { movieDetails ->
            movieDetailsMapper.toMovieDetailsViewState(movieDetails)
        }.stateIn(viewModelScope, SharingStarted.Lazily, MovieDetailsViewState.getEmptyObject())

    fun toggleFavorite(Id: Int) {
        viewModelScope.launch {
            movieRepository.toggleFavorite(Id)
        }
    }
}
