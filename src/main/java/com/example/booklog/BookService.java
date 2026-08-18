package com.example.booklog;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book getBookById(int id) {
        return bookRepository.findById(id);
    }

    public boolean deleteBook(int id) {
        return bookRepository.deleteById(id);
    }

    public Book updateBook(int id, Book updatedBook) {
        return bookRepository.update(id, updatedBook);
    }
}
