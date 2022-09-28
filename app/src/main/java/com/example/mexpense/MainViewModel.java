package com.example.mexpense;

import android.app.Application;
import android.provider.ContactsContract;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mexpense.data.BookEntity;
import com.example.mexpense.data.SampleDataProvider;
import com.example.mexpense.data.TripEntity;

import java.util.List;

public class MainViewModel extends ViewModel {


    MutableLiveData<List<BookEntity>> bookList = new MutableLiveData<List<BookEntity>>();
    { //static code run once
        bookList.setValue(SampleDataProvider.getBooks());
    }

    MutableLiveData<List<TripEntity>> tripList = new MutableLiveData<List<TripEntity>>();
    { //static code run once
        getTrip();
    }

    private void getTrip() {

    }
}