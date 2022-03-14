package com.example.projectarbetecomplexjavaspring.service;

import com.example.projectarbetecomplexjavaspring.entity.BookEntity;
import com.example.projectarbetecomplexjavaspring.entity.LibraryEntity;
import com.example.projectarbetecomplexjavaspring.repository.BookRepository;
import com.example.projectarbetecomplexjavaspring.repository.LibraryRepository;
import org.springframework.stereotype.Service;



@Service
public class LibraryService {

    private final LibraryRepository libraryRepository;
    private final BookRepository bookRepository;

    public LibraryService(LibraryRepository libraryRepository, BookRepository bookRepository) {
        this.libraryRepository = libraryRepository;
        this.bookRepository = bookRepository;
    }

    public LibraryEntity createLibrary(LibraryEntity libraryEntity) {
        return libraryRepository.save(libraryEntity);
    }

    public Iterable<LibraryEntity> findAllLibraries() {
        return libraryRepository.findAll();
    }

    public LibraryEntity updateLibrary(LibraryEntity library) {

        LibraryEntity existingLibrary = libraryRepository.findById(library.getLibraryId()).orElse(null);
        existingLibrary.setName(library.getName());
        existingLibrary.setBooks(library.getBooks());

        return libraryRepository.save(existingLibrary);
    }



}
