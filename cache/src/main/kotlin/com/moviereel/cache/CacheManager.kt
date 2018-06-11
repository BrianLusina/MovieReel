package com.moviereel.cache

import com.moviereel.data.source.DataCache
import com.moviereel.data.source.movies.repo.MovieLocalRepo

/**
 * @author lusinabrian on 03/06/18.
 * @Notes Cache Manager is responsible for delegating cache tasks to the relevant sub-divided cache
 * layers, in this case, the MovieNowPlaying, MovieLatest, MovieTopRated, etv, as well as TV cache
 * layers. This is used to further subdivide up the responsibilities
 */
interface CacheManager : MovieLocalRepo, DataCache