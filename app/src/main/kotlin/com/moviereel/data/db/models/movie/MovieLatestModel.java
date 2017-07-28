package com.moviereel.data.db.models.movie;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

/**
 * @author lusinabrian on 15/05/17.
 * @Notes Data entry for the latest movie
 */
@Entity(
        nameInDb = "movie_latest",
        active = true
)
public class MovieLatestModel {

    @Id
    private long id;

    @Property
    private String belongsToCollection;

    @Property
    private int budget;

    @Property
    private String homepage;

    @Property
    private String imdbId;

// TODO: ADD RELATIONS TO OTHER TABLES, production companies, countries and spoken languages
//    @Property
//    private Genres genres;
//    @Property
//    private List<ProductionCompany> productionCompanies;
//
//    @Property
//    private List<ProductionCountry> productionCountries;
//
//    @Property
//    private List<SpokenLanguage> spokenLanguages;
//
//    @Property
//    private List<Integer> genreIds;

    @Property
    private int revenue;

    @Property
    private int runtime;

    @Property
    private String status;

    @Property
    private String tagline;

    @Property
    private boolean adult;

    @Property
    private String posterPath;

    @Property
    private String overview;

    @Property
    private String originalLanguage;

    @Property
    private String backdropPath;

    @Property
    private boolean video;

    @Property
    private int voteCount;

    @Property
    private float voteAverage;

    @Property
    private float popularity;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1362376518)
    private transient MovieLatestModelDao myDao;

    @Generated(hash = 1225164557)
    public MovieLatestModel(long id, String belongsToCollection, int budget, String homepage,
            String imdbId, int revenue, int runtime, String status, String tagline,
            boolean adult, String posterPath, String overview, String originalLanguage,
            String backdropPath, boolean video, int voteCount, float voteAverage,
            float popularity) {
        this.id = id;
        this.belongsToCollection = belongsToCollection;
        this.budget = budget;
        this.homepage = homepage;
        this.imdbId = imdbId;
        this.revenue = revenue;
        this.runtime = runtime;
        this.status = status;
        this.tagline = tagline;
        this.adult = adult;
        this.posterPath = posterPath;
        this.overview = overview;
        this.originalLanguage = originalLanguage;
        this.backdropPath = backdropPath;
        this.video = video;
        this.voteCount = voteCount;
        this.voteAverage = voteAverage;
        this.popularity = popularity;
    }

    @Generated(hash = 1868089798)
    public MovieLatestModel() {
    }
    
    public String getBelongsToCollection() {
        return belongsToCollection;
    }

    public void setBelongsToCollection(String belongsToCollection) {
        this.belongsToCollection = belongsToCollection;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
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

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 679005826)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getMovieLatestModelDao() : null;
    }
}
