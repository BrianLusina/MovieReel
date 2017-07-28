package com.moviereel.data.db.models.movie;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

/**
 * @author lusinabrian on 16/05/17.
 * @Notes An upcoming Movie model. Used when storing upcoming movie items in the database
 *
 * An example of data we will be storing
 * {
 *  "poster_path": "/qwoGfcg6YUS55nUweKGujHE54Wy.jpg",
 *  "adult": false,
 *  "overview": "Captain Jack Sparrow is pursued by an old rival, Captain Salazar, who along with his crew of ghost pirates has escaped from the Devil's Triangle, and is determined to kill every pirate at sea. Jack seeks the Trident of Poseidon, a powerful artifact that grants its possessor total control over the seas, in order to defeat Salazar.",
 *  "release_date": "2017-05-24",
 *  "genre_ids": [ 28, 12, 35, 14 ],
 *  "id": 166426,
 *  "original_title": "Pirates of the Caribbean: Dead Men Tell No Tales",
 *  "original_language": "en",
 *  "title": "Pirates of the Caribbean: Dead Men Tell No Tales",
 *  "backdrop_path": "/3DVKG54lqYbdh8RNylXeCf4MBPw.jpg",
 *  "popularity": 19.733165,
 *  "vote_count": 49,
 *  "video": false,
 *  "vote_average": 0
 *  }
 */

@Entity(
        nameInDb = "movie_upcoming",
        active = true
)
public class MovieUpcomingModel {
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
    @Generated(hash = 1790539438)
    private transient MovieUpcomingModelDao myDao;

    @Generated(hash = 696779689)
    public MovieUpcomingModel(long id, String posterPath, String overview, String releaseDate, String originalTitle, String originalLanguage, String title, String backdropPath, long popularity, int voteCount, boolean video, long voteAverage) {
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

    @Generated(hash = 516876862)
    public MovieUpcomingModel() {
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

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
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
    @Generated(hash = 1070270792)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getMovieUpcomingModelDao() : null;
    }
}
