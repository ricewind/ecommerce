package com.example.ecommerce.ui.carro;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CarroViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CarroViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Carro");
    }

    public LiveData<String> getText() {
        return mText;
    }
}