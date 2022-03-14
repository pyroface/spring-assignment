package com.example.projectarbetecomplexjavaspring.service;

import com.example.projectarbetecomplexjavaspring.entity.BookEntity;
import com.example.projectarbetecomplexjavaspring.entity.LibraryEntity;
import com.example.projectarbetecomplexjavaspring.repository.BookRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookEntity createBook(BookEntity bookEntity) {
        return bookRepository.save(bookEntity);
    }

    public void deleteBook(Long bookId) {
        BookEntity foundBook = bookRepository.findById(bookId).orElseThrow(EntityNotFoundException::new);
        bookRepository.deleteById(foundBook.getBookId());
    }

    public Optional<BookEntity> findBookById(Long bookId) {
        return bookRepository.findById(bookId);
    }

    public Iterable<BookEntity> findAllBooks() {
        return bookRepository.findAll();
    }

}
