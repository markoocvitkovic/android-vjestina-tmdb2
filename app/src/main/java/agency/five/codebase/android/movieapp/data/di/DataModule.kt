package agency.five.codebase.android.movieapp.data.di

import agency.five.codebase.android.movieapp.data.repository.MovieRepositoryImpl
import agency.five.codebase.android.movieapp.data.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val dataModule = module {
    single<MovieRepository> {
        MovieRepositoryImpl(
            movieService = get(),
            movieDao = get(),
            bgDispatcher = Dispatchers.IO
        )
    }
}
