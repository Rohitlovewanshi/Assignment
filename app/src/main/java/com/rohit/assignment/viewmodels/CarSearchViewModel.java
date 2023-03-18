package com.rohit.assignment.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.rohit.assignment.models.ApiResponse;
import com.rohit.assignment.repositories.CarRepository;

public class CarSearchViewModel extends ViewModel {

    private CarRepository carRepository;
    private LiveData<ApiResponse> apiResponseLiveData;

    public void init() {
        carRepository = new CarRepository();
        apiResponseLiveData = carRepository.getCarsResponseLiveDate();
    }

    public void searchCars() {
        carRepository.searchCars();
    }

    public LiveData<ApiResponse> getApiResponseLiveData() {
        return apiResponseLiveData;
    }
}
