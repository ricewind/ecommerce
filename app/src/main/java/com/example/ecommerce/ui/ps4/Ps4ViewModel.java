package com.example.ecommerce.ui.ps4;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Ps4ViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public Ps4ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("PS4");
    }

    public LiveData<String> getText() {
        return mText;
    }
}