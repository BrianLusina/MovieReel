# Movie Reel

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/c1b48e5c27784d79a3234df3ced6d5c6)](https://www.codacy.com/app/BrianLusina/MovieReel-app?utm_source=github.com&utm_medium=referral&utm_content=BrianLusina/MovieReel-app&utm_campaign=badger)

Simple Android application which features your latest movies.

##__Features and User Stories__
___

+ User can view the latest movies in a list. This list will use a RecyclerView to display the items
+ Each movie item is displayed using an ImageView and text about the movie.
+ Uses Coordinator Layout to enable refreshing of data
+ Source of movies is from [Apiary API](https://www.themoviedb.org)

## Dependencies, APIs and Libraries Used

+ __Movie DB API__
    
    The project requires on Movie DB API to fetch data about movies and tv shows. An API key is needed. This key is used to retrieve data from MovieDB API.
    
    It is recommended that the key is stored in your `gradle.properties` file (which should not be pushed to Github, or any other VCS) after which add them to your contracts class,or constants class before including them in your `build.gradle` file at the app level.
    
+ __Paolo Ratolo's App Intro dependency__
    
    App Intro allows simple and short introduction into the application. They are only shown once on 1st ever start of the app. After which the splash screen will be shown for a brief 2 second.
    
    Remember to use SharedPreferences to enable only one start of this introduction.

+ __Glide__
    This library assists in loading images from a Uri resouce and load the images into your ImageViews. This is used for the Movie posters.
    
+ __Ripple Effect__
    
    Adds a ripple effect to the item cards when clicked.
    
+ __Material View Pager__
    
    Used to display the movie details.

+ __Android Iconics__

    Used for fonts and Icons
    
### Data storage
    
Data is stored using SharedPreferences. Of course there are several ways to access this data, intention is to allow user to still access this data offline. 
The mode has been set to 0 to allow only this application to have access.

``` java
SharedPreferences movieData = getActivity().getSharedPreferences("MovieData",0);
```

Then you have to create an Editor instance and add the data to the SharedPreferences in *Key*, *Value* pairs

``` java
SharedPreferences.Editor editor = movieData.edit();
```

Then of course you can then add the Key,Value pairs

``` java
editor.putString("Key", value);
//...more data
```

Now you can access the data as you see fit. Of course you can alternatively use any other type of database to store you data locally(SQLite) or even a file which will only allow your app to have read-write access.
