package sk.durixx.library.domain;

import sk.durixx.library.model.dto.LibraryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.durixx.library.model.entity.Library;
import sk.durixx.library.repository.LibraryRepository;

@Service
public class LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    public void createNewLibrary(LibraryDto library) {
        validateLibrary(library);
        libraryRepository.save(Library.fromDto(library));
    }

    private void validateLibrary(LibraryDto library) {
        if (library.getNameOfLibrary().isEmpty()) throw new IllegalArgumentException("please add name");
        if (library.getCountry().isEmpty()) throw new IllegalArgumentException("please add county");
        if (library.getAddress().isEmpty()) throw new IllegalArgumentException("please add address");
        if (library.getCity().isEmpty()) throw new IllegalArgumentException("please add city");
    }
}
