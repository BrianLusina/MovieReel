package com.moviereel.data.db.models.movie;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

/**
 * @author lusinabrian on 15/05/17.
 * @Notes Popular Movie Model (POJO) that will be mapped to a row in the table movie_popular
 * in the database
 */
@Entity(
        nameInDb = "movie_popular",
        active = true
)
public class MoviePopularModel {

    @Id
    private long id;

    @Property(nameInDb = "adult")
    private boolean adult;

    @Property(nameInDb = "poster_path")
    private String posterPath;

    @Property(nameInDb = "overview")
    private String overview;

    @Property(nameInDb = "original_language")
    private String originalLanguage;

    @Property(nameInDb = "backdrop_path")
    private String backdropPath;

    @Property(nameInDb = "video")
    private boolean video;

    @Property(nameInDb = "vote_count")
    private int voteCount;

    @Property(nameInDb = "vote_average")
    private float voteAverage;

    @Property(nameInDb = "popularity")
    private float popularity;

    @Property(nameInDb = "release_date")
    private String releaseDate;

    @Property(nameInDb = "title")
    private String title;

    @Property(nameInDb = "original_title")
    private String originalTitle;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1320143508)
    private transient MoviePopularModelDao myDao;

    @Generated(hash = 1569657427)
    public MoviePopularModel(long id, boolean adult, String posterPath, String overview,
            String originalLanguage, String backdropPath, boolean video, int voteCount,
            float voteAverage, float popularity, String releaseDate, String title,
            String originalTitle) {
        this.id = id;
        this.adult = adult;
        this.posterPath = posterPath;
        this.overview = overview;
        this.originalLanguage = originalLanguage;
        this.backdropPath = backdropPath;
        this.video = video;
        this.voteCount = voteCount;
        this.voteAverage = voteAverage;
        this.popularity = popularity;
        this.releaseDate = releaseDate;
        this.title = title;
        this.originalTitle = originalTitle;
    }

    @Generated(hash = 1527167876)
    public MoviePopularModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
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

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public float getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(float voteAverage) {
        this.voteAverage = voteAverage;
    }

    public float getPopularity() {
        return popularity;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public boolean getAdult() {
        return this.adult;
    }

    public boolean getVideo() {
        return this.video;
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
    @Generated(hash = 803244253)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getMoviePopularModelDao() : null;
    }
}
