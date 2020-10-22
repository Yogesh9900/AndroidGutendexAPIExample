package com.prayosof.gutenbergassignment.retrofit;

import com.prayosof.gutenbergassignment.model.Books;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MyApiEndpointInterface {

    @GET("/books")
    Call<Books> getBooksData(@Query("topic") String topic, @Query("page") int page);
}

