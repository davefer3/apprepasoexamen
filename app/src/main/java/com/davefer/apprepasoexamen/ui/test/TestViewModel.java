package com.davefer.apprepasoexamen.ui.test;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TestViewModel extends ViewModel {


    private MutableLiveData<String> mText;

    public TestViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Test Fragment");

    }

    public LiveData<String> getText() {
        return mText;
    }

}
