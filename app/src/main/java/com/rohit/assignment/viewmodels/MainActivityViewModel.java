package com.rohit.assignment.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.rohit.assignment.models.ApiResponse;
import com.rohit.assignment.repositories.ApiRepository;

public class MainActivityViewModel extends AndroidViewModel {

    private ApiRepository apiRepository;
    private LiveData<ApiResponse> apiResponseLiveData;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        apiRepository = new ApiRepository(getApplication());
        apiResponseLiveData = apiRepository.getCarsResponseLiveDate();
    }

    public void searchCars() {
        apiRepository.fetchApi();
    }

    public LiveData<ApiResponse> getApiResponseLiveData() {
        return apiResponseLiveData;
    }
}
