package com.moviereel.data.db.models.movie;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Unique;

/**
 * @author lusinabrian
 * @Notes: Now playing movie model
 *
 * Example model we should expect to save
 * "poster_path": "/y4MBh0EjBlMuOzv9axM4qJlmhzz.jpg",
 * "adult": false,
 * "overview": "The Guardians must fight to keep their newfound family together as they unravel the mysteries of Peter Quill's true parentage.",
 * "releaseDate": "2017-04-24",
 * "genre_ids": [ 35, 28, 12, 878 ],
 * "id": 283995,
 * "original_title": "Guardians of the Galaxy Vol. 2",
 * "original_language": "en",
 * "title": "Guardians of the Galaxy Vol. 2",
 * "backdrop_path": "/aJn9XeesqsrSLKcHfHP4u5985hn.jpg",
 * "popularity": 125.757946,
 * "vote_count": 1437,
 * "video": false,
 * */
@Entity(
        nameInDb = "movie_now_playing",
        active = true
)
public class MovieNowPlayingModel {

    @Property(nameInDb = "movieId")
    @Unique
    private int movieId;

    @Property(nameInDb = "movieImdbId")
    @Unique
    private String movieImdbId;

    @Property(nameInDb = "name")
    private String movieTitle;

    @Property(nameInDb = "posterUrl")
    private String moviePosterUrl;

    @Property(nameInDb = "backdropUrl")
    private String movieBackdropUrl;

    @Property(nameInDb = "overview")
    private String movieOverview;

    @Property(nameInDb = "releaseDate")
    private String releaseDate;

    @Property(nameInDb = "homepage")
    private String movieHomepage;

    @Property(nameInDb = "originalLang")
    private String originalLang;

    @Property(nameInDb = "originalTitle")
    private String originalTitle;

    @Property(nameInDb = "movieStatus")
    private String movieStatus;

    @Property(nameInDb = "movieTagline")
    private String movieTagline;

    @Property(nameInDb = "movieGenres")
    private String movieGenres;

    @Property(nameInDb = "productionCompanies")
    private String productionCompanies;

    @Property(nameInDb = "productionCountries")
    private String productionCountries;

    @Property(nameInDb = "spokenLanguages")
    private String spokenLanguages;

    // TODO: 19/04/17 Adding relation for genre ids
    // @Property(nameInDb = "genre_ids")
    // private Integer[] movie_genres;

    @Property(nameInDb = "voteCount")
    private int movieVoteCount;

    @Property(nameInDb = "runtime")
    private int movieRuntime;

    @Property(nameInDb = "popularity")
    private float moviePopularity;

    @Property(nameInDb = "voteAverage")
    private float voteAverage;

    @Property(nameInDb = "isAdult")
    private boolean isAdult;

    @Property(nameInDb = "hasVideo")
    private boolean hasVideo;

    @Property(nameInDb = "revenue")
    private long movieRevenue;

    /*ACCESS METHODS*/
    public String getMoviePosterUrl() {
    return moviePosterUrl;
}

    public void setMoviePosterUrl(String moviePosterUrl) {
        this.moviePosterUrl = moviePosterUrl;
    }

    public String getMovieBackdropUrl() {
        return movieBackdropUrl;
    }

    public void setMovieBackdropUrl(String movieBackdropUrl) {
        this.movieBackdropUrl = movieBackdropUrl;
    }

    public int getMovieVoteCount() {
        return movieVoteCount;
    }

    public void setMovieVoteCount(int movieVoteCount) {
        this.movieVoteCount = movieVoteCount;
    }

    public double getMoviePopularity() {
        return moviePopularity;
    }

    public void setMoviePopularity(float moviePopularity) {
        this.moviePopularity = moviePopularity;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String MovieName) {
        this.movieTitle = MovieName;
    }

    public String getMovieOverview() {
        return movieOverview;
    }

    public void setMovieOverview(String movieOverview) {
        this.movieOverview = movieOverview;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public float getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(float voteAverage) {
        this.voteAverage = voteAverage;
    }

    public boolean isAdult() {
        return isAdult;
    }

    public void setAdult(boolean adult) {
        isAdult = adult;
    }

    public boolean isHasVideo() {
        return hasVideo;
    }

    public void setHasVideo(boolean hasVideo) {
        this.hasVideo = hasVideo;
    }

    public int getMovieRuntime() {
        return movieRuntime;
    }

    public void setMovieRuntime(int movieRuntime) {
        this.movieRuntime = movieRuntime;
    }

    public String getMovieHomepage() {
        return movieHomepage;
    }

    public void setMovieHomepage(String movieHomepage) {
        this.movieHomepage = movieHomepage;
    }

    public String getMovieImdbId() {
        return movieImdbId;
    }

    public void setMovieImdbId(String movieImdbId) {
        this.movieImdbId = movieImdbId;
    }

    public String getMovieStatus() {
        return movieStatus;
    }

    public void setMovieStatus(String movieStatus) {
        this.movieStatus = movieStatus;
    }

    public String getMovieTagline() {
        return movieTagline;
    }

    public void setMovieTagline(String movieTagline) {
        this.movieTagline = movieTagline;
    }

    public String getMovieGenres() {
        return movieGenres;
    }

    public void setMovieGenres(String movieGenres) {
        this.movieGenres = movieGenres;
    }

    public long getMovieRevenue() {
        return movieRevenue;
    }

    public void setMovieRevenue(long movieRevenue) {
        this.movieRevenue = movieRevenue;
    }

    public String getProductionCompanies() {
        return productionCompanies;
    }

    public void setProductionCompanies(String productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    public String getProductionCountries() {
        return productionCountries;
    }

    public void setProductionCountries(String productionCountries) {
        this.productionCountries = productionCountries;
    }

    public String getSpokenLanguages() {
        return spokenLanguages;
    }

    public void setSpokenLanguages(String spokenLanguages) {
        this.spokenLanguages = spokenLanguages;
    }

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 703920389)
    private transient MovieNowPlayingModelDao myDao;

    @Generated(hash = 1556537836)
    public MovieNowPlayingModel(int movieId, String movieImdbId, String movieTitle, String moviePosterUrl, String movieBackdropUrl,
            String movieOverview, String releaseDate, String movieHomepage, String originalLang, String originalTitle, String movieStatus,
            String movieTagline, String movieGenres, String productionCompanies, String productionCountries, String spokenLanguages,
            int movieVoteCount, int movieRuntime, float moviePopularity, float voteAverage, boolean isAdult, boolean hasVideo,
            long movieRevenue) {
        this.movieId = movieId;
        this.movieImdbId = movieImdbId;
        this.movieTitle = movieTitle;
        this.moviePosterUrl = moviePosterUrl;
        this.movieBackdropUrl = movieBackdropUrl;
        this.movieOverview = movieOverview;
        this.releaseDate = releaseDate;
        this.movieHomepage = movieHomepage;
        this.originalLang = originalLang;
        this.originalTitle = originalTitle;
        this.movieStatus = movieStatus;
        this.movieTagline = movieTagline;
        this.movieGenres = movieGenres;
        this.productionCompanies = productionCompanies;
        this.productionCountries = productionCountries;
        this.spokenLanguages = spokenLanguages;
        this.movieVoteCount = movieVoteCount;
        this.movieRuntime = movieRuntime;
        this.moviePopularity = moviePopularity;
        this.voteAverage = voteAverage;
        this.isAdult = isAdult;
        this.hasVideo = hasVideo;
        this.movieRevenue = movieRevenue;
    }

    @Generated(hash = 1204606922)
    public MovieNowPlayingModel() {
    }
    

    @Override
    public String toString() {
        return "MovieNowPlayingModel{" +
                "movieTitle='" + movieTitle + '\'' +
                ", moviePosterUrl='" + moviePosterUrl + '\'' +
                ", movieBackdropUrl='" + movieBackdropUrl + '\'' +
                ", movieOverview='" + movieOverview + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", movieHomepage='" + movieHomepage + '\'' +
                ", movieImdbId='" + movieImdbId + '\'' +
                ", movieStatus='" + movieStatus + '\'' +
                ", movieTagline='" + movieTagline + '\'' +
                ", movieGenres='" + movieGenres + '\'' +
                ", productionCompanies='" + productionCompanies + '\'' +
                ", productionCountries='" + productionCountries + '\'' +
                ", spokenLanguages='" + spokenLanguages + '\'' +
                ", movieId=" + movieId +
                ", movieVoteCount=" + movieVoteCount +
                ", movieRuntime=" + movieRuntime +
                ", moviePopularity=" + moviePopularity +
                ", voteAverage=" + voteAverage +
                ", isAdult=" + isAdult +
                ", hasVideo=" + hasVideo +
                ", movieRevenue=" + movieRevenue +
                '}';
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOriginalLang() {
        return this.originalLang;
    }

    public void setOriginalLang(String originalLang) {
        this.originalLang = originalLang;
    }

    public boolean getIsAdult() {
        return this.isAdult;
    }

    public void setIsAdult(boolean isAdult) {
        this.isAdult = isAdult;
    }

    public boolean getHasVideo() {
        return this.hasVideo;
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
    @Generated(hash = 1914449607)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getMovieNowPlayingModelDao() : null;
    }
}
