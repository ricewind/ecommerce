package com.example.ecommerce;

import java.util.ArrayList;

public class Utilities {

    public static ArrayList<ListObject> populateFirstList() {
        ArrayList<ListObject> mFirstList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            ListObject mListObject = new ListObject("NN.N€", "Novedad " + i+1);
            mFirstList.add(mListObject);
        }

        return mFirstList;
    }

    public static ArrayList<ListObject> populateSecondList() {
        ArrayList<ListObject> mSecondList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            ListObject mListObject = new ListObject(" NN.N€", "Oferta" + i+1);
            mSecondList.add(mListObject);
        }

        return mSecondList;
    }

}
