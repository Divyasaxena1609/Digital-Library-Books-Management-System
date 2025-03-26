package com.library.bookmanagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.bookmanagement.Model.Books;
import com.library.bookmanagement.Repository.BooksRepository;

@Service
public class BooksService {
    @Autowired
    private BooksRepository booksRepo;
    
    public Books addBook(Books book) {
        return booksRepo.save(book);
    }

    public List<Books> viewAllBooks() {
        return booksRepo.findAll();
    }

    public Books searchBookById(String bookId) {
        return booksRepo.findByBookId(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found with ID: " + bookId));
    }

    public Books searchBookByTitle(String title) {
        return booksRepo.findByTitle(title)
                .orElseThrow(() -> new RuntimeException("Book not found with Title: " + title));
    }

    public Books updateBook(String bookId, Books updatedBook) {
        Books book = searchBookById(bookId);
        book.setTitle(updatedBook.getTitle());
        book.setAuthor(updatedBook.getAuthor());
        book.setGenre(updatedBook.getGenre());
        book.setAvailabilityStatus(updatedBook.getAvailabilityStatus());
        return booksRepo.save(book);
    }

    public void deleteBook(String bookId) {
        Books book = searchBookById(bookId);
        booksRepo.delete(book);
    }
}
