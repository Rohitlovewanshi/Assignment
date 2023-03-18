package com.rohit.assignment.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.rohit.assignment.models.ApiResponse;
import com.rohit.assignment.repositories.CarRepository;

public class MainActivityViewModel extends AndroidViewModel {

    private CarRepository carRepository;
    private LiveData<ApiResponse> apiResponseLiveData;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public void init() {
        carRepository = new CarRepository(getApplication());
        apiResponseLiveData = carRepository.getCarsResponseLiveDate();
    }

    public void searchCars() {
        carRepository.fetchApi();
    }

    public LiveData<ApiResponse> getApiResponseLiveData() {
        return apiResponseLiveData;
    }
}
