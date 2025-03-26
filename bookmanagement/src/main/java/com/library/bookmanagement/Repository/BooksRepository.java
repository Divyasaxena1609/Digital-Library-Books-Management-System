package com.library.bookmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.bookmanagement.Model.Books;
import java.util.Optional;

@Repository
public interface BooksRepository extends JpaRepository<Books , Long>{
    Optional<Books> findByBookId(String bookId);
    Optional<Books> findByTitle(String title);
}
