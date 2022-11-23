package sk.durixx.library.open;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sk.durixx.library.domain.BookService;
import sk.durixx.library.model.dto.BookDto;
import sk.durixx.library.model.entity.Book;


import java.util.List;

@Component
public class BookApi {

    @Autowired
    BookService bookService;

    public void createNewBook(BookDto book) {
        bookService.createNewBook(book);
    }

    public BookDto readBook(Long id) {
        return BookDto.fromBook(bookService.readBook(id));
    }

    public void updateBook(BookDto book) {
        bookService.updateBook(Book.fromDto(book));
    }

    public void deleteBook(Long id) {
        bookService.deleteBook(id);
    }

    public List<BookDto> readAll() {
        return bookService.readAll()
                .stream()
                .map(BookDto::fromBook)
                .toList();
    }

    public void patchBook(BookDto book, Long id) {
        bookService.patchBook(Book.fromDto(book), id);
    }
}
