package com.rohit.assignment.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.rohit.assignment.models.ApiResponse;
import com.rohit.assignment.apis.CarSearchService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CarRepository {

    private static final String CAR_SEARCH_SERVICE_BASE_URL = "https://mocki.io/";

    private CarSearchService carSearchService;
    private MutableLiveData<ApiResponse> apiResponseLiveData;

    public CarRepository() {
        apiResponseLiveData = new MutableLiveData<>();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        carSearchService = new Retrofit.Builder()
                .baseUrl(CAR_SEARCH_SERVICE_BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CarSearchService.class);
    }

    public void searchCars() {
        carSearchService.searchCars()
                .enqueue(new Callback<ApiResponse>() {
                    @Override
                    public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                        if (response.body() != null) {
                            apiResponseLiveData.postValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<ApiResponse> call, Throwable t) {
                        apiResponseLiveData.postValue(null);
                    }
                });
    }

    public LiveData<ApiResponse> getCarsResponseLiveDate() {
        return apiResponseLiveData;
    }
}
