package com.example.mywebapp

import retrofit2.http.GET

interface ChuckNorrisAPI {
    //@GET("jokes/random")
    ///suspend fun getRandomJoke(): Joke

    @GET("?api_key=ceb88457f1584daab5fc9503a1084a28&fields=continent,city")
    suspend fun geoLocate(): Joke
}