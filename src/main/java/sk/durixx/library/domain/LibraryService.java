package sk.durixx.library.domain;

import sk.durixx.library.model.dto.LibraryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.durixx.library.model.entity.Library;
import sk.durixx.library.repository.LibraryRepository;

import java.util.List;

@Service
public class LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    public void createNewLibrary(LibraryDto library) {
        validateLibrary(Library.fromDto(library));
        libraryRepository.save(Library.fromDto(library));
    }

    public Library readLibrary(Long id) {
        return libraryRepository.findById(id).orElseThrow();
    }

    public void updateLibrary(Library library) {
        libraryRepository.save(library);
    }

    public void deleteLibrary(Long id) {
        libraryRepository.delete(libraryRepository.getReferenceById(id));
    }

    public List<Library> readAll() {
        return libraryRepository.findAll();
    }

    public void patchLibrary(Library library, Long id) {
        Library loadLibrary = libraryRepository.getReferenceById(id);

        if (library.getNameOfLibrary() != null) loadLibrary.setNameOfLibrary(library.getNameOfLibrary());
        if (library.getAddress() != null) loadLibrary.setAddress(library.getAddress());
        if (library.getCity() != null) loadLibrary.setCity(library.getCity());
        if (library.getCountry() != null) loadLibrary.setCountry(library.getCountry());

        libraryRepository.save(loadLibrary);
    }

    private void validateLibrary(Library library) {
        if (library.getNameOfLibrary().isEmpty()) throw new IllegalArgumentException("please add name");
        if (library.getCountry().isEmpty()) throw new IllegalArgumentException("please add county");
        if (library.getAddress().isEmpty()) throw new IllegalArgumentException("please add address");
        if (library.getCity().isEmpty()) throw new IllegalArgumentException("please add city");
    }
}
