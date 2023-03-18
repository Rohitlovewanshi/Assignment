package com.rohit.assignment;

import android.app.Application;

import com.rohit.assignment.di.DaggerRetroComponent;
import com.rohit.assignment.di.RetroComponent;
import com.rohit.assignment.di.RetroModule;

public class MyApplication extends Application {

    private RetroComponent retroComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        retroComponent = DaggerRetroComponent.builder()
                .retroModule(new RetroModule())
                .build();
    }

    public RetroComponent getRetroComponent() {
        return retroComponent;
    }
}
