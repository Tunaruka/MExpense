package com.example.mexpense;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mexpense.data.BookEntity;
import com.example.mexpense.data.SampleDataProvider;

import java.util.List;

public class EditorViewModel extends ViewModel {
    MutableLiveData<BookEntity> book = new MutableLiveData<BookEntity>();
        public void getBookById(String id){
            if (id == null || id == Constants.NEW_BOOK_ID) {
                book.setValue(new BookEntity());
                return;
            }

        }
}