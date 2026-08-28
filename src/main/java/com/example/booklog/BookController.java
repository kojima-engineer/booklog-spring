package com.example.booklog;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class BookController {

    // ① クラスの一番上に書く
    private final BookService bookService;

    // ② そのすぐ下に書く
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring Boot!";
    }

    @PostMapping("/booklog")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {

        Book savedBook = bookService.addBook(book);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedBook);
    }

    @GetMapping("/booklog")
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/booklog/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {

        Book book = bookService.getBookById(id);

        if (book != null) {
            return ResponseEntity.ok(book);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/booklog/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id) {

        boolean deleted = bookService.deleteBook(id);

        if (deleted) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/booklog/{id}")
    public ResponseEntity<Book> updateBook(
            @PathVariable int id,
            @RequestBody Book updatedBook) {

        Book book = bookService.updateBook(id, updatedBook);

        if (book != null) {
            return ResponseEntity.ok(book);
        }

        return ResponseEntity.notFound().build();
    }
}

