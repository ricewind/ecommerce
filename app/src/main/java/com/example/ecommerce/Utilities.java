package com.example.ecommerce;

import java.util.ArrayList;

public class Utilities {

    public static ArrayList<ListObject> populateFirstList() {
        ArrayList<ListObject> mFirstList = new ArrayList<>();

        for (int i = 0; i < 1; i++) {
            ListObject mListObject = new ListObject("NN.N€", "Novedad " + i+1);
            mFirstList.add(mListObject);
        }

        return mFirstList;
    }

    public static ArrayList<ListObject> populateSecondList() {
        ArrayList<ListObject> mSecondList = new ArrayList<>();

        for (int i = 0; i < 1; i++) {
            ListObject mListObject = new ListObject(" NN.N€", "oferta" + i+1);
            mSecondList.add(mListObject);
        }

        return mSecondList;
    }

    public static ArrayList<ListObject> populateThirdList() {
        ArrayList<ListObject> mThirdList = new ArrayList<>();

        for (int i = 0; i < 1; i++) {
            ListObject mListObject = new ListObject("NN.N€", "PS4 " + i+1);
            mThirdList.add(mListObject);
        }

        return mThirdList;
    }

    public static ArrayList<ListObject> populateFourthList() {
        ArrayList<ListObject> mFourthList = new ArrayList<>();

        for (int i = 0; i < 1; i++) {
            ListObject mListObject = new ListObject("NN.N€", "Xbox " + i+1);
            mFourthList.add(mListObject);
        }

        return mFourthList;
    }
}
