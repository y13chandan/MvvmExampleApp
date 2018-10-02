package com.example.root.mvvmexampleapp.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class ScoreViewModel extends ViewModel {
    private MutableLiveData<Integer> count = new MutableLiveData<>();

    public void setCount(int count) {
        this.count.setValue(count);
    }

    public MutableLiveData<Integer> getCount() {
        return count;
    }
}
