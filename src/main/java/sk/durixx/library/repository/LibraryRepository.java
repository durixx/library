package sk.durixx.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import sk.durixx.library.model.entity.Library;

@Service
public interface LibraryRepository extends JpaRepository<Library, Long> {

}
