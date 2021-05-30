package com.example.ecommerce.ui.xbox;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class XboxViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public XboxViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("XBOX");
    }

    public LiveData<String> getText() {
        return mText;
    }
}