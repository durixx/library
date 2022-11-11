package sk.durixx.library.open;

import sk.durixx.library.model.dto.LibraryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sk.durixx.library.domain.LibraryService;
import sk.durixx.library.model.entity.Library;

import java.util.List;


@Component
public class LibraryApi {

    @Autowired
    LibraryService libraryService;

    public void createNewLibrary(LibraryDto library) {
        libraryService.createNewLibrary(library);
    }

    public LibraryDto readLibrary(Long id) {
        return LibraryDto.fromLibrary(libraryService.readLibrary(id));
    }

    public void updateLibrary(LibraryDto library) {
        libraryService.updateLibrary(Library.fromDto(library));
    }

    public void deleteLibrary(Long id) {
        libraryService.deleteLibrary(id);
    }

    public List<LibraryDto> readAll() {
        return libraryService.readAll()
                .stream()
                .map(LibraryDto::fromLibrary)
                .toList();
    }

    public void patchLibrary(LibraryDto library, Long id) {
        libraryService.patchLibrary(Library.fromDto(library), id);
    }

}
