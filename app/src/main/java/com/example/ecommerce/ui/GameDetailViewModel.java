package com.example.ecommerce.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GameDetailViewModel extends ViewModel{

    private MutableLiveData<String> mText;

    public GameDetailViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("GameDetail");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
