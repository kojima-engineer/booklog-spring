package com.example.booklog;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    private String title;
    private String author;
    private String memo;

    public Book() {
    }

    public Book(int id, String title, String author, String memo) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.memo = memo;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getMemo() {
        return memo;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}