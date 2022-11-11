package sk.durixx.library.rest;

import sk.durixx.library.model.dto.LibraryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sk.durixx.library.open.LibraryApi;
import java.util.List;

@RestController
@RequestMapping("api/library")
public class LibraryRest {

    @Autowired
    public LibraryApi libraryApi;

    @PostMapping
    public void createNewLibrary(@RequestBody LibraryDto library) {
        libraryApi.createNewLibrary(library);
    }

    @GetMapping("/{id}")
    public LibraryDto readLibrary(@PathVariable Long id) {
        return libraryApi.readLibrary(id);
    }

    @PutMapping
    public void updateLibrary(@RequestBody LibraryDto library) {
        libraryApi.updateLibrary(library);
    }

    @DeleteMapping("/{id}")
    public void deleteLibrary(@PathVariable Long id) {
        libraryApi.deleteLibrary(id);
    }

    @GetMapping("/all")
    public List<LibraryDto> readAll() {
        return libraryApi.readAll();
    }

    @PatchMapping("/{id}")
    public void patchLibrary(@RequestBody LibraryDto library, @PathVariable Long id) {
        libraryApi.patchLibrary(library, id);
    }


}
