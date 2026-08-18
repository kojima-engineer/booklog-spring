package com.example.booklog;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    private List<Book> books = new ArrayList<>();

    public BookRepository() {
        books.add(new Book(1, "嫌われる勇気", "岸見一郎", "自己啓発"));
        books.add(new Book(2, "ワンピース", "尾田栄一郎", "漫画"));
        books.add(new Book(3, "鬼滅の刃", "吾峠呼世晴", "漫画"));
    }
    public List<Book> findAll() {
        return books;
    }

    public Book save(Book book) {
        books.add(book);
        return book;
    }
    public Book findById(int id) {

        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }

        return null;
    }

    public boolean deleteById(int id) {
        return books.removeIf(book -> book.getId() == id);
    }

    public Book update(int id, Book updatedBook) {

        for (Book book : books) {

            if (book.getId() == id) {

                book.setTitle(updatedBook.getTitle());
                book.setAuthor(updatedBook.getAuthor());
                book.setMemo(updatedBook.getMemo());

                return book;
            }
        }

        return null;
    }
}