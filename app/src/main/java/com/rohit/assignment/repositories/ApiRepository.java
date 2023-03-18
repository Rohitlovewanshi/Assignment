package com.rohit.assignment.repositories;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.rohit.assignment.MyApplication;
import com.rohit.assignment.di.RetroServiceInterface;
import com.rohit.assignment.models.ApiResponse;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiRepository {

    private MutableLiveData<ApiResponse> apiResponseLiveData;

    private Context context;

    @Inject
    RetroServiceInterface mService;

    public ApiRepository(Context context) {
        this.context = context;
        apiResponseLiveData = new MutableLiveData<>();

        ((MyApplication) context).getRetroComponent().inject(ApiRepository.this);

    }

    public void fetchApi() {
        mService.fetchApi()
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
