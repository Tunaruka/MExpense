package com.example.mexpense;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mexpense.data.BookEntity;
import com.example.mexpense.data.SampleDataProvider;

import java.util.List;

public class MainViewModel extends ViewModel {

    MutableLiveData<List<BookEntity>> bookList = new MutableLiveData<List<BookEntity>>();
    { //static code run once
        bookList.setValue(SampleDataProvider.getBooks());
    }
}