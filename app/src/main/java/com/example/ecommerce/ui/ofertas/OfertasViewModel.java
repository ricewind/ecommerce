package com.example.ecommerce.ui.ofertas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OfertasViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public OfertasViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Ofertas");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
