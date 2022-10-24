package sk.durixx.library.open;

import sk.durixx.library.model.dto.LibraryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sk.durixx.library.domain.LibraryService;

@Component
public class LibraryApi {

    @Autowired
    LibraryService libraryService;

    public void createNewLibrary(LibraryDto library) {
        libraryService.createNewLibrary(library);
    }
}
