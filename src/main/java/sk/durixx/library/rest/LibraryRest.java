package sk.durixx.library.rest;

import sk.durixx.library.model.dto.LibraryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.durixx.library.model.entity.Library;
import sk.durixx.library.open.LibraryApi;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/library")
public class LibraryRest {

    @Autowired
    public LibraryApi libraryApi;

    @PostMapping("/create")
    public void createNewLibrary(@RequestBody LibraryDto library) {
        libraryApi.createNewLibrary(library);
    }

    @GetMapping("/read/{id}")
    public LibraryDto readLibrary(@PathVariable Long id) {
        return libraryApi.readLibrary(id);
    }

    @PutMapping("/update")
    public void updateLibrary(@RequestBody LibraryDto library) {
        libraryApi.updateLibrary(library);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteLibrary(@PathVariable Long id) {
        libraryApi.deleteLibrary(id);
    }

    @GetMapping("read/all")
    public List<LibraryDto> readAll() {
        return libraryApi.readAll();
    }
}
