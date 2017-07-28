package com.moviereel.data.db.models.movie;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

/**
 * @author lusinabrian on 16/05/17.
 * @Notes Top rated POJO. Represents 1 row in the table movie_top_rated
 *
 * An example of what we expect:
 *
 * "poster_path": "/2gvbZMtV1Zsl7FedJa5ysbpBx2G.jpg",
 * "adult": false,
 * "overview": "Raj is a rich, carefree, happy-go-lucky second generation NRI. Simran is the daughter of Chaudhary Baldev Singh, who in spite of being an NRI is very strict about adherence to Indian values. Simran has left for India to be married to her childhood fiancé. Raj leaves for India with a mission at his hands, to claim his lady love under the noses of her whole family. Thus begins a saga.",
 * "release_date": "1995-10-19",
 * "genre_ids": [35,18,10749],
 * "id": 19404,
 * "original_title": "दिलवाले दुल्हनिया ले जाएंगे",
 * "original_language": "hi",
 * "title": "Dilwale Dulhania Le Jayenge",
 * "backdrop_path": "/nl79FQ8xWZkhL3rDr1v2RFFR6J0.jpg",
 * "popularity": 2.879931,
 * "vote_count": 183,
 * "video": false,
 * "vote_average": 8.8
 */

@Entity(
        nameInDb = "movie_top_rated",
        active = true
)
public class MovieTopRatedModel {

    @Id
    private long id;

    @Property(nameInDb = "poster_path")
    private String posterPath;

    @Property(nameInDb = "overview")
    private String overview;

    @Property(nameInDb = "release_date")
    private String releaseDate;

    @Property(nameInDb = "original_title")
    private String originalTitle;

    @Property(nameInDb = "original_language")
    private String originalLanguage;

    @Property(nameInDb = "title")
    private String title;

    @Property(nameInDb = "backdrop_path")
    private String backdropPath;

    @Property(nameInDb = "popularity")
    private long popularity;

    @Property(nameInDb = "vote_count")
    private int voteCount;

    @Property(nameInDb = "video")
    private boolean video;

    @Property(nameInDb = "vote_averate")
    private long voteAverage;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 138650711)
    private transient MovieTopRatedModelDao myDao;

    @Generated(hash = 1052424752)
    public MovieTopRatedModel(long id, String posterPath, String overview, String releaseDate, String originalTitle, String originalLanguage, String title, String backdropPath, long popularity, int voteCount, boolean video, long voteAverage) {
        this.id = id;
        this.posterPath = posterPath;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.originalTitle = originalTitle;
        this.originalLanguage = originalLanguage;
        this.title = title;
        this.backdropPath = backdropPath;
        this.popularity = popularity;
        this.voteCount = voteCount;
        this.video = video;
        this.voteAverage = voteAverage;
    }

    @Generated(hash = 702257499)
    public MovieTopRatedModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public long getPopularity() {
        return popularity;
    }

    public void setPopularity(long popularity) {
        this.popularity = popularity;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public long getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(long voteAverage) {
        this.voteAverage = voteAverage;
    }

    public boolean getVideo() {
        return this.video;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 2106525689)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getMovieTopRatedModelDao() : null;
    }
}
