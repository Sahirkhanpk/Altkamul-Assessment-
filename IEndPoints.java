package com.example.altkamulassesignment.api;



import androidx.annotation.NonNull;

import com.example.altkamulassesignment.model.Media;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import rx.Observable;


public interface IEndPoints {

    // get token
    @NonNull
    @GET("/svc/mostpopular/v2/mostviewed/all-sections/7.json?api-key=BPBMGAWRLKQlpZ5hZSx57YGnCaEbtqTm")
    //@GET("token.php")
    @Headers("Content-Type: application/json")
    Observable<List<Media>> getArticals();






}
