package sk.durixx.library.config.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.durixx.library.config.model.Library;
import sk.durixx.library.config.repository.LibraryRepository;

@Service
public class LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    public void createNewLibrary(Library library) {
        libraryRepository.save(library);
    }
}
