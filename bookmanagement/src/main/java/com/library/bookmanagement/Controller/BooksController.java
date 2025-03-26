package com.library.bookmanagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.bookmanagement.CustomResponse.ResponseApi;
import com.library.bookmanagement.Model.Books;
import com.library.bookmanagement.Service.BooksService;

@RestController
@RequestMapping("/books")  
public class BooksController {

    @Autowired
    private BooksService bookService;

    @PostMapping("/add")
    public ResponseEntity<ResponseApi<Books>> addBook(@RequestBody Books book) {
        Books AddBook = bookService.addBook(book);
        ResponseApi<Books> response = new ResponseApi<>("Book Added successfully", AddBook);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseApi<List<Books>>> viewAllBooks() {
        List<Books> allBooks = bookService.viewAllBooks();
        ResponseApi<List<Books>> response = new ResponseApi<>("Books retrieved successfully", allBooks);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/search/id/{bookId}")
    public ResponseEntity<ResponseApi<Books>> searchBookById(@PathVariable String bookId) {
        Books searchBook = bookService.searchBookById(bookId);
        ResponseApi<Books> response = new ResponseApi<>("Book retrieved successfully", searchBook);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/search/title/{title}")
    public ResponseEntity<ResponseApi<Books>> searchBookByTitle(@PathVariable String title) {
        Books searchBook = bookService.searchBookByTitle(title);
        ResponseApi<Books> response = new ResponseApi<>("Book retrieved successfully", searchBook);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update/{bookId}")
    public ResponseEntity<ResponseApi<Books>> updateBook(@PathVariable String bookId, @RequestBody Books updatedBook) {
        try {
            Books updateBook = bookService.updateBook(bookId, updatedBook);
            ResponseApi<Books> response = new ResponseApi<>("Book updated successfully", updateBook);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            ResponseApi<Books> response = new ResponseApi<>("Failed to update Book", null);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<ResponseApi<Void>> deleteBook(@PathVariable String bookId) {
        try {
            bookService.deleteBook(bookId);
            ResponseApi<Void> response = new ResponseApi<>("Book deleted successfully.", null);
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {
            ResponseApi<Void> response = new ResponseApi<>("Book not found", null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
