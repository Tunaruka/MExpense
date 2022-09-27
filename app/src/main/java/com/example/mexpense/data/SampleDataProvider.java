package com.example.mexpense.data;

import java.util.ArrayList;
import java.util.List;

public class SampleDataProvider {
    public static List<BookEntity> getBooks() {
        List<BookEntity> books = new ArrayList<>();
        books.add(new BookEntity("1", "Kohlin for Beginner", "Google", 123));
        books.add(new BookEntity("2", "Fundamentals of Reacts", "Facebook", 345));
        books.add(new BookEntity("3", "Advanced Laravel", "Laracast", 879));
        return books;

    }
}
