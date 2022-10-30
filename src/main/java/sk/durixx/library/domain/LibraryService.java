package sk.durixx.library.domain;

import sk.durixx.library.model.dto.LibraryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.durixx.library.model.entity.Library;
import sk.durixx.library.repository.LibraryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public void updateLibrary(LibraryDto library) {
        libraryRepository.save(Library.fromDto(library));
    }

    public void deleteLibrary(Long id) {
        libraryRepository.delete(libraryRepository.getReferenceById(id));
    }

    public List<Library> readAll() {
       return libraryRepository.findAll();
    }

    private void validateLibrary(Library library) {
        if (library.getNameOfLibrary().isEmpty()) throw new IllegalArgumentException("please add name");
        if (library.getCountry().isEmpty()) throw new IllegalArgumentException("please add county");
        if (library.getAddress().isEmpty()) throw new IllegalArgumentException("please add address");
        if (library.getCity().isEmpty()) throw new IllegalArgumentException("please add city");
    }
}
