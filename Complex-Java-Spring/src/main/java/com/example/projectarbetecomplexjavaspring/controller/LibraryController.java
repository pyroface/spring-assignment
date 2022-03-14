package com.example.projectarbetecomplexjavaspring.controller;

import com.example.projectarbetecomplexjavaspring.entity.BookEntity;
import com.example.projectarbetecomplexjavaspring.entity.LibraryEntity;
import com.example.projectarbetecomplexjavaspring.repository.BookRepository;
import com.example.projectarbetecomplexjavaspring.service.LibraryService;
import com.example.projectarbetecomplexjavaspring.repository.LibraryRepository;
import org.apache.tomcat.jni.Library;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("libraries")
public class LibraryController {
    private final LibraryService libraryService;

    private final LibraryRepository libraryRepository;
    private final BookRepository bookRepository;

    public LibraryController(LibraryService libraryService, LibraryRepository libraryRepository, BookRepository bookRepository) {
        this.libraryService = libraryService;
        this.libraryRepository = libraryRepository;
        this.bookRepository = bookRepository;
    }

    @PostMapping()
    public ResponseEntity<LibraryEntity> createLibrary(@RequestBody LibraryEntity libraryEntity) {
        LibraryEntity createdLibrary = libraryService.createLibrary(libraryEntity);
        return new ResponseEntity<>(createdLibrary, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<Iterable<LibraryEntity>> findAllLibraries() {
        Iterable<LibraryEntity> allLibraries = libraryService.findAllLibraries();
        return new ResponseEntity<>(allLibraries, HttpStatus.OK);
    }

    @PutMapping("/update")
    public LibraryEntity updateLibrary(@RequestBody LibraryEntity library) {
        return libraryService.updateLibrary(library);
    }

    /*
    @PutMapping("/{libraryId}/bookupdate/{bookId}")
    public LibraryEntity assignBookToLibrary(
            @PathVariable Long libraryId,
            @PathVariable Long bookId
    ) {
        LibraryEntity library = libraryRepository.findById(libraryId).get();
        BookEntity book = bookRepository.findById(bookId).get();

        book.setLibrary(library);

        return libraryRepository.save(library);
    }
    */

}
