package com.example.projectarbetecomplexjavaspring.controller;

import com.example.projectarbetecomplexjavaspring.entity.BookEntity;
import com.example.projectarbetecomplexjavaspring.entity.StudentEntity;
import com.example.projectarbetecomplexjavaspring.exceptions.NoContentException;
import com.example.projectarbetecomplexjavaspring.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping()
    public ResponseEntity<BookEntity> createBook(@RequestBody BookEntity bookEntity) {
        BookEntity createdBook = bookService.createBook(bookEntity);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }
    @DeleteMapping("{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long bookId) {
        bookService.deleteBook(bookId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("{bookId}")
    public ResponseEntity<Optional<BookEntity>> findBookById(@PathVariable Long bookId) {
        Optional<BookEntity> foundBook = bookService.findBookById(bookId);
        String message = "Couldn't find book with requested ID";
        if (foundBook.isEmpty()) {
            throw new NoContentException(message);
        } else {
            return new ResponseEntity<>(foundBook, HttpStatus.OK);
        }
    }

    @GetMapping()
    public ResponseEntity<Iterable<BookEntity>> findAllBooks() {
        Iterable<BookEntity> allBooks = bookService.findAllBooks();
        return new ResponseEntity<>(allBooks, HttpStatus.OK);
    }

}
