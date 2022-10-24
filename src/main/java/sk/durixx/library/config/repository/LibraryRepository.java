package sk.durixx.library.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import sk.durixx.library.config.model.Library;

@Service
public interface LibraryRepository extends JpaRepository<Library, Long> {

}
