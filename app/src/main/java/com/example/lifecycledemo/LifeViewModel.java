package com.example.lifecycledemo;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class LifeViewModel extends ViewModel {

    private MutableLiveData<String> mName = new MutableLiveData<>();

    public MutableLiveData<String> getmName() {
        return mName;
    }
}
