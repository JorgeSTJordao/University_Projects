package com.example.mywebapp

import retrofit2.http.GET

interface ChuckNorrisAPI {
    //@GET("jokes/random")
    ///suspend fun getRandomJoke(): Joke
    @GET("/random")
    suspend fun quotes(): Joke
}