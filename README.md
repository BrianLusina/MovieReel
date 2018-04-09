# MovieReel

[![CircleCI](https://circleci.com/gh/BrianLusina/MovieReel-app.svg?style=svg)](https://circleci.com/gh/BrianLusina/MovieReel-app)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/c1b48e5c27784d79a3234df3ced6d5c6)](https://www.codacy.com/app/BrianLusina/MovieReel-app?utm_source=github.com&utm_medium=referral&utm_content=BrianLusina/MovieReel-app&utm_campaign=badger)
[![codecov](https://codecov.io/gh/BrianLusina/MovieReel-app/branch/master/graph/badge.svg)](https://codecov.io/gh/BrianLusina/MovieReel-app)
[![Build status](https://build.appcenter.ms/v0.1/apps/703b6e52-7cea-4dbb-b803-3864b388c75b/branches/master/badge)](https://appcenter.ms)

Simple Android application which features your latest movies and series

## Getting started

Clone the repo

```bash
$ git clone https://github.com/BrianLusina/MovieReel.git
```

Create a `gradle.properties` file at root of project and include the following:

```properties
MovieDbKey="<YOUR_MOVIE_TMDB_KEY>"
IMAGE_BASE_URL="http://image.tmdb.org/t/p/"
IMAGE_SECURE_BASE_URL="https://image.tmdb.org/t/p/"
```
> Get your Movie DB key from [here](https://developers.themoviedb.org/3/getting-started)

That will be it for the project setup.

### Running test

Most of the tests are unit test, for quick and easy testing.
Run them with:

```bash
./gradlew test
```

To run instrumented tests:

```bash
./gradlew connectedAndroidTest
```

Make sure you have a connected debuggable device, or an emulator running.