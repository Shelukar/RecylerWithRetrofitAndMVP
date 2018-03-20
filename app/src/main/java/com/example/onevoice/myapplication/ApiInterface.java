package com.example.onevoice.myapplication;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by onevoice on 28/2/18.
 */

public interface ApiInterface {

    /*   @GET("movie/{id}")
      Call<MoviesResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
  */
    @GET("/api/users")
    Call<Example> getTopRatedMovies(@Query("page") String page);

    @POST("/api/users")
    Call<User> createUser(@Body User user);


}
