package sk.durixx.library.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.durixx.library.model.dto.BookDto;
import sk.durixx.library.open.BookApi;

import java.util.List;

@RestController
@RequestMapping("api/book")
public class BookRest {

    @Autowired
    public BookApi bookApi;

    @PostMapping
    public void createNewBook(@RequestBody BookDto book) {
        bookApi.createNewBook(book);
    }

    @GetMapping("/{id}")
    public BookDto readBook(@PathVariable Long id) {
        return bookApi.readBook(id);
    }

    @PutMapping
    public void updateBook(@RequestBody BookDto book) {
        bookApi.updateBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookApi.deleteBook(id);
    }

    @GetMapping("/all")
    public List<BookDto> readAll() {
        return bookApi.readAll();
    }

    @PatchMapping("/{id}")
    public void patchBook(@RequestBody BookDto book, @PathVariable Long id) {
        bookApi.patchBook(book, id);
    }
}
