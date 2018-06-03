import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.moviereel.cache.db.MovieReelDatabase
import com.moviereel.cache.db.dao.movies.MovieNowPlayingDao
import com.moviereel.cache.factory.MovieCacheDataFactory
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieNowPlayingDaoTest{

    private lateinit var movieNowPlayingDao : MovieNowPlayingDao
    private lateinit var database: MovieReelDatabase

    @Before
    fun setUp(){
        val context = InstrumentationRegistry.getTargetContext()
        database = Room.inMemoryDatabaseBuilder(context, MovieReelDatabase::class.java)
                .allowMainThreadQueries()
                .build()
        movieNowPlayingDao = database.getMovieNowPlayingDao()
    }

    @After
    @Throws(Exception::class)
    fun tearDown(){
        database.close()
    }

    @Test
    fun testInsertMovieNowPlayingCache(){
        val movieCache = MovieCacheDataFactory.makeMovieNowPlayingCacheModel()
        movieNowPlayingDao.insertMovieNp(movieCache)
        val actualMovie = movieNowPlayingDao.getMovieNpById(movieCache.id)
        assertEquals(actualMovie, movieCache)
    }
}