package com.example.projectarbetecomplexjavaspring.repository;

import com.example.projectarbetecomplexjavaspring.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Long> {
    BookEntity findByName(String name);
}
