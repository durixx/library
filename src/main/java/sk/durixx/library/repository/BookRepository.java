package sk.durixx.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.durixx.library.model.entity.Book;


public interface BookRepository extends JpaRepository<Book, Long> {
}
