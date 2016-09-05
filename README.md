# Movie Reel

Simple Android application which features your latest movies.

##__Features and User Stories__
___

+ User can view the latest movies in a list. This list will use a RecyclerView to display the items
+ Each movie item is displayed using an ImageView and text about the movie.
+ Uses Coordinator Layout to enable refreshing of data
+ Source of movies is from [Apiary API](https://www.themoviedb.org)

## Project Requirements

+ Movie DB API
    The project requires on Movie DB API to fetch data about movies and tv shows. An API key is needed. This key is used to retrieve data from MovieDB API.
    
    It is recommended that the key is stored in your `gradle.properties` file (which should not be pushed to Github, or any other VCS) after which add them to your contracts class,or constants class before including them in your `build.gradle` file at the app level.