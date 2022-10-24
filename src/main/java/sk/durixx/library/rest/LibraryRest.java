package sk.durixx.library.rest;

import sk.durixx.library.model.dto.LibraryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.durixx.library.open.LibraryApi;

@RestController
@RequestMapping("api/library")
public class LibraryRest {

    @Autowired
    public LibraryApi libraryApi;

    @PostMapping("/create")
    public void createNewLibrary(@RequestBody LibraryDto library) {
        libraryApi.createNewLibrary(library);
    }


}
