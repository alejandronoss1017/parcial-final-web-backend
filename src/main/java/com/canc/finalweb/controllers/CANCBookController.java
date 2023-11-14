package com.canc.finalweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canc.finalweb.dtos.CANCBookDto;
import com.canc.finalweb.models.CANCBook;
import com.canc.finalweb.services.CANCBookService;

@RestController
@RequestMapping(path = "/api/books")
@CrossOrigin(origins = "*")
public class CANCBookController {

    @Autowired
    private CANCBookService bookService;

    @GetMapping(path = "/all")
    public ResponseEntity<Iterable<CANCBookDto>> getAllBooks() throws Exception {

        Iterable<CANCBookDto> books = bookService.getAllBooks();

        if (books == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(books);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CANCBookDto> getBookById(Long id) throws Exception {

        CANCBookDto book = bookService.getBookById(id);

        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }

    @PostMapping(path = "/save")
    public ResponseEntity<CANCBook> saveBook(@RequestBody CANCBookDto book) throws Exception {

        CANCBook bookSaved = bookService.saveBook(book);

        if (bookSaved == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bookSaved);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<CANCBook> updateBook(@RequestBody CANCBookDto book) throws Exception {

        CANCBook bookUpdated = bookService.updateBook(book);

        if (bookUpdated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bookUpdated);
    }

    @PostMapping(path = "/delete/{id}")
    public ResponseEntity<Void> deleteBook(Long id) throws Exception {

        bookService.deleteBook(id);

        return ResponseEntity.ok().build();
    }

}
