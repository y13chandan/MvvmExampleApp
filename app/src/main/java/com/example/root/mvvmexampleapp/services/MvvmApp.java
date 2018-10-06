package com.example.root.mvvmexampleapp.services;

import android.app.Application;

import com.example.root.mvvmexampleapp.di.component.MvvmComponent;
import com.example.root.mvvmexampleapp.di.module.AppModule;

public class MvvmApp extends Application {

    private MvvmComponent mvvmComponent;

    @Override
    public void onCreate() {
        super.onCreate();

    }
}
