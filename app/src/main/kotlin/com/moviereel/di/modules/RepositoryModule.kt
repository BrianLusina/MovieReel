package com.moviereel.di.modules

import com.moviereel.data.repositories.RepositoryHelper
import com.moviereel.data.repositories.RepositoryHelperImpl
import com.moviereel.data.repositories.movierepo.MovieDataSource
import com.moviereel.data.repositories.movierepo.MoviesRepoHelper
import com.moviereel.data.repositories.movierepo.MoviesRepoHelperImpl
import com.moviereel.data.repositories.movierepo.local.MoviesLocalDataSource
import com.moviereel.data.repositories.movierepo.remote.MoviesRemoteDataSource
import com.moviereel.di.LocalRepo
import com.moviereel.di.RemoteRepo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * @author lusinabrian on 08/08/17.
 * @Notes Module for repositories
 */
@Module
class RepositoryModule {
    @Provides
    @LocalRepo
    @Singleton
    fun provideLocalDataSource(moviesLocalDataSource: MoviesLocalDataSource): MovieDataSource {
        return moviesLocalDataSource
    }

    @Provides
    @RemoteRepo
    @Singleton
    fun provideRemoteDataSource(moviesRemoteDataSource: MoviesRemoteDataSource): MovieDataSource {
        return moviesRemoteDataSource
    }

    @Provides
    @Singleton
    fun provideRepository(repositoryHelper: RepositoryHelperImpl): RepositoryHelper {
        return repositoryHelper
    }

    @Provides
    @Singleton
    fun provideMovieRepo(moviesRepoHelper: MoviesRepoHelperImpl) : MoviesRepoHelper{
        return moviesRepoHelper
    }
}