package info.androidhive.retrofit.rest;

import info.androidhive.retrofit.model.MoviesResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterface {
    @GET("discover/movie")
    Call<MoviesResponse> getSpielberg(@Query("api_key") String apiKey, @Query("with_people") String id, @Query("sort_by") String sort);
    @GET("discover/movie")
    Call<MoviesResponse> getLucas(@Query("api_key") String apiKey, @Query("with_people") String id, @Query("sort_by") String sort);
    @GET("discover/movie")
    Call<MoviesResponse> getCameron(@Query("api_key") String apiKey, @Query("with_people") String id, @Query("sort_by") String sort);
//    @GET("movie/{id}")
//    Call<MoviesResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
//    @GET("discover/movie")
//    Call<MoviesResponse> getSpielberg(@Query("api_key") String apiKey, @Query("with_people") String id, @Query("sort_by") String sort);
}
