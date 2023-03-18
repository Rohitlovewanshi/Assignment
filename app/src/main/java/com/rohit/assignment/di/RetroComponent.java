package com.rohit.assignment.di;

import com.rohit.assignment.repositories.CarRepository;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {RetroModule.class})
public interface RetroComponent {

    public void inject(CarRepository carRepository);
}
