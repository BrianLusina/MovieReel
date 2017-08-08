package com.moviereel.data.db

import com.moviereel.data.db.entities.movie.MovieLatestEntity
import com.moviereel.data.db.entities.movie.MovieNPEntity
import com.moviereel.data.db.entities.movie.MoviePEntity
import com.moviereel.data.db.entities.movie.MovieTREntity

import io.reactivex.Observable

/**
 * @author lusinabrian on 28/03/17
 * * Interface that will be delegated the duty of storing and accessing the database
 * * will be implemented by [DbHelperImpl]
 * * follows CRUD principle
 */

interface DbHelper {
    // CREATE
    // create all the entities in the database exactly as they are fetched from the db

    /**
     * Inserts a movie item into the database. This will map the POJO to a movie item
     * @param movieNPEntity POJO representation of a movie item received from API
     * *
     * @return [Boolean] True if insertion is successful, false, otherwise
     * *
     */
    fun insertMovieNowPlayingItem(movieNPEntity: MovieNPEntity): Observable<Boolean>

    /**
     * Inserts a movie item list into the database, BULK INSERT
     * @param movieNPEntities List of movie items
     * *
     * @return [Boolean] True if insertion is a success, false otherwise
     * *
     */
    fun insertMovieNowPlayingItemList(movieNPEntities: List<MovieNPEntity>): Observable<Boolean>

    /**
     * Inserts the latest movie item to the data
     * @param movieLatestEntity latest movie model
     * *
     * @return [Boolean] True if data insertion is a success, False otherwise
     * *
     */
    fun insertMovieLatestItem(movieLatestEntity: MovieLatestEntity): Observable<Boolean>

    /**
     * Inserts a popular movie item to the database
     * @param moviePEntity POJO with data relating to a popular movie item
     * *
     * @return [Boolean] True if insertion of data is a success, False otherwise
     */
    fun insertMoviePopularItem(moviePEntity: MoviePEntity): Observable<Boolean>

    /**
     * Inserts a list of Popular movie items to the database
     * @param moviePEntities List of popular movie items
     * *
     * @return [Boolean] True if insertion of list is a success
     */
    fun insertMoviePopularItemList(moviePEntities: List<MoviePEntity>): Observable<Boolean>

    /**
     * Inserts a single top rated movie into the database
     * @param movieTREntity top rated movie model
     * *
     * @return [Boolean] True if insertion of data is successful
     */
    fun insertMovieTopRatedItem(movieTREntity: MovieTREntity): Observable<Boolean>

    /**
     * Inserts a list of top rated movies
     * @param movieTREntities list of top rated movies to insert
     * *
     * @return [Boolean] True, if insertion is a success
     */
    fun insertMovieTopRatedItemList(movieTREntities: List<MovieTREntity>): Observable<Boolean>

    //----------------------------------------------------------------------------------------------
    // READ
    // read data from the db

    /**
     * Gets a now playing movie item from the database database.
     * @param movieNowPlayingId Id of a now playing movie item
     * *
     * @return [MovieNPEntity] MovieNowPlaying Model
     * *
     */
    fun getNowPlayingMovieItem(movieNowPlayingId: Long): Observable<MovieNPEntity>

    /**
     * Retrieves all the now playing movie items from a database
     * @return [<] List of now playing movie items
     * *
     */
    val movieNPItems: Observable<List<MovieNPEntity>>

    /**
     * Gets the latest movie item by its given id
     * @param movieLatestModelId latest movie model id
     * *
     * @return [MovieLatestEntity] Latest Movie Latest model
     * *
     */
    fun getMovieLatestItem(movieLatestModelId: Long): Observable<MovieLatestEntity>

    /**
     * Gets a popular movie item from the database
     * @param moviePopularId Id of a popular movie item
     * *
     * @return [MoviePEntity] popular movie item
     */
    fun getMoviePopularItem(moviePopularId: Long): Observable<MoviePEntity>

    /**
     * Gets a list of popular movie items from db
     * @return [<] List of popular movie items
     */
    val moviePItemList: Observable<List<MoviePEntity>>

    /**
     * Inserts a single top rated movie into the database
     * @param movieTopRatedId top rated movie model id
     * *
     * @return [MovieTREntity] Top rated movie model
     */
    fun getMovieTopRatedItem(movieTopRatedId: Long): Observable<MovieTREntity>

    /**
     * Inserts a list of top rated movies
     * @return [<] List of top rated movies
     */
    val movieTRItemList: Observable<List<MovieTREntity>>

    //----------------------------------------------------------------------------------------------
    // UPDATE
    // update data in the db

    /**
     * Updates a now playing movie item.
     * @param movieNPEntity Id of a now playing movie item
     * *
     * @return [Boolean] True if update is a success
     * *
     */
    fun updateNowPlayingMovieItem(movieNPEntity: MovieNPEntity): Observable<Boolean>

    /**
     * Updates latest movie item
     * @param movieLatestEntity latest movie model
     * *
     * @return [Boolean] True if data insertion is a success, False otherwise
     * *
     */
    fun updateMovieLatestItem(movieLatestEntity: MovieLatestEntity): Observable<Boolean>

    /**
     * Updates a popular movie item
     * @param moviePEntity POJO with data relating to a popular movie item
     * *
     * @return [Boolean] True if updating the data item was a success
     */
    fun updateMoviePopularItem(moviePEntity: MoviePEntity): Observable<Boolean>

    /**
     * Updates a top rated movie item
     * @param movieTREntity top rated movie model
     * *
     * @return [Boolean] True if updating of data is successful
     */
    fun updateMovieTopRatedItem(movieTREntity: MovieTREntity): Observable<Boolean>

    //----------------------------------------------------------------------------------------------
    // DELETE
    // delete data from the db

    /**
     * Deletes a movie now playing item given its id
     * @param movieNowPlayingId Id of a now playing movie item
     * *
     * @return [Long] id of the deleted movie now playing item
     * *
     */
    fun deleteNowPlayingMovieItem(movieNowPlayingId: Long): Observable<Long>

    /**
     * Deletes all movie now playing items
     * @return [Integer] Number of deleted items from the database
     * *
     */
    fun deleteMovieNowPlayingItems(movieNPEntities: List<MovieNPEntity>): Observable<Int>

    /**
     * Deletes the latest movie item given its id
     * @param movieLatestId latest movie model id
     * *
     * @return [Boolean] True if data deletion is a success, False otherwise
     * *
     */
    fun deleteMovieLatestItem(movieLatestId: Long): Observable<Boolean>

    /**
     * Inserts a popular movie item to the database
     * @param moviePopularId POJO with data relating to a popular movie item
     * *
     * @return [Long] id of deleted popular movie item
     */
    fun deleteMoviePopularItem(moviePopularId: Long): Observable<Long>

    /**
     * Inserts a list of Popular movie items to the database
     * @param moviePEntities List of popular movie items
     * *
     * @return [Integer] number of deleted items
     */
    fun deleteMoviePopularItemList(moviePEntities: List<MoviePEntity>): Observable<Int>

    /**
     * Deletes a single top rated movie item from db
     * @param movieTopRatedId top rated movie model id
     * *
     * @return [Long] id of deleted data item
     */
    fun deleteMovieTopRatedItem(movieTopRatedId: Long): Observable<Long>

    /**
     * Deletes top rated movie item list
     * @param movieTREntities list of top rated movies to insert
     * *
     * @return [Integer] List size of deleted items from database
     */
    fun deleteMovieTopRatedItemList(movieTREntities: List<MovieTREntity>): Observable<Int>
}