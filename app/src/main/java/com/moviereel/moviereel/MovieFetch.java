package com.moviereel.moviereel;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLConnection;
import java.util.List;

/**
 * Project: Movie Reel
 * Package: com.moviereel.moviereel
 * Created by lusinabrian on 20/08/16 at 10:41
 * Description: Responsible for making HTTP call and getting the response
 * url – The url to make a http call
 * method – The http method either GET or POST. We should pass ServiceHandler.GET or ServiceHandler.POST as value
 * params – Any parameters you want to submit to that url. This is optional.
 */
public class MovieFetch{
    protected final String KEY = "2f30bdb7e9742c26d4ea364f62f38163";
    protected final String BASEURL="https://api.themoviedb.org/3/";

    /*url to fetch GENRES*/
    protected final String GENRES = BASEURL + "/genre/movie/list?"+KEY;

    static String response = null;
    public final static int GET = 1;
    public final static int POST = 2;

    public MovieFetch() {}

}
