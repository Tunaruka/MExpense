package com.example.mexpense.data;

import com.example.mexpense.Constants;

public class BookEntity {
    private String id;
    private String title;
    private String author;
    private int pages;

    public BookEntity() {
        this (
                Constants.NEW_BOOK_ID,
                Constants.EMPTY_STRING,
                Constants.EMPTY_STRING,
                0

        );
    }

    public BookEntity(String title, String author, int pages) {
        this (Constants.NEW_BOOK_ID, title, author, pages);
    }

    public BookEntity(String id, String title, String author, int pages) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }


    @Override
    public String toString() {
        return "BookEntity{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                '}';
    }
}
