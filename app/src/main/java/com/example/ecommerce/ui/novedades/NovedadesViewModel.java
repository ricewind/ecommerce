package com.example.ecommerce.ui.novedades;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NovedadesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public NovedadesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Novedades");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
