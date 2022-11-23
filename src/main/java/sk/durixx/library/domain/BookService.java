package sk.durixx.library.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.durixx.library.model.dto.BookDto;
import sk.durixx.library.model.entity.Book;
import sk.durixx.library.repository.BookRepository;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void createNewBook(BookDto book) {
        validateBook(Book.fromDto(book));
        bookRepository.save(Book.fromDto(book));
    }

    public Book readBook(Long id) {
        return bookRepository.findById(id).orElseThrow();
    }

    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.delete(bookRepository.getReferenceById(id));
    }

    public List<Book> readAll() {
        return bookRepository.findAll();
    }

    public void patchBook(Book book, Long id) {
        Book loadBook = bookRepository.getReferenceById(id);

        if (book.getName() != null) loadBook.setName(book.getName());
        if (book.getAuthor() != null) loadBook.setAuthor(book.getAuthor());
        if (book.getYearOfRelease() != 0) loadBook.setYearOfRelease(book.getYearOfRelease());
        if (book.getDescription() != null) loadBook.setDescription(book.getDescription());
        if (book.getIsbn() != 0) loadBook.setIsbn(book.getIsbn());

        bookRepository.save(loadBook);
    }


    private void validateBook(Book book) {
        if (book.getName().isEmpty()) throw new IllegalArgumentException("please add name");
        if (book.getAuthor().isEmpty()) throw new IllegalArgumentException("please add author");
        if (book.getYearOfRelease() == 0) throw new IllegalArgumentException("please add year of release");
        if (book.getDescription().isEmpty()) throw new IllegalArgumentException("please add description");
        if (book.getIsbn() == 0) throw new IllegalArgumentException("please add ISBN");
    }
}
