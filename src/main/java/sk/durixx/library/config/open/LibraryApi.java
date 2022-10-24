package sk.durixx.library.config.open;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sk.durixx.library.config.domain.LibraryService;
import sk.durixx.library.config.model.Library;

@Component
public class LibraryApi {

    @Autowired
    LibraryService libraryService;

    public void createNewLibrary(Library library) {
        libraryService.createNewLibrary(library);
    }
}
