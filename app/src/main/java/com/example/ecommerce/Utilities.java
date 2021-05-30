package com.example.ecommerce;

import java.util.ArrayList;

public class Utilities {

    public static ArrayList<ListObject> populateFirstList() {
        ArrayList<ListObject> mFirstList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            ListObject mListObject = new ListObject("NN.N€", "Titulo");
            mFirstList.add(mListObject);
        }

        return mFirstList;
    }

    public static ArrayList<ListObject> populateSecondList() {
        ArrayList<ListObject> mSecondList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            ListObject mListObject = new ListObject("NN.N€", "Titulo");
            mSecondList.add(mListObject);
        }

        return mSecondList;
    }

    public static ArrayList<ListObject> populateThirdList() {
        ArrayList<ListObject> mThirdList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            ListObject mListObject = new ListObject("NN.N€", "Titulo");
            mThirdList.add(mListObject);
        }

        return mThirdList;
    }

    public static ArrayList<ListObject> populateFourthList() {
        ArrayList<ListObject> mFourthList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            ListObject mListObject = new ListObject("NN.N€", "Titulo");
            mFourthList.add(mListObject);
        }

        return mFourthList;
    }
}
