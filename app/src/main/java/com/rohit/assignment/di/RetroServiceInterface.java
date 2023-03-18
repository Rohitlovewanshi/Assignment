package com.rohit.assignment.di;

import com.rohit.assignment.models.ApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetroServiceInterface {

    @GET("v1/a53f9e9d-edf0-496c-a705-33040569a7da")
    Call<ApiResponse> fetchApi();
}
