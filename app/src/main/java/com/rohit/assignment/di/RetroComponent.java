package com.rohit.assignment.di;

import com.rohit.assignment.repositories.ApiRepository;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {RetroModule.class})
public interface RetroComponent {

    public void inject(ApiRepository apiRepository);
}
