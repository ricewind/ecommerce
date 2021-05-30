package com.example.ecommerce.ui.home;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private ImageView image;


    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("U-Commerce");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }
}