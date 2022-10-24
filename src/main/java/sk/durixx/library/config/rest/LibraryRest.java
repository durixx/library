package sk.durixx.library.config.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.durixx.library.config.model.Library;
import sk.durixx.library.config.open.LibraryApi;

@RestController
@RequestMapping("api/library")
public class LibraryRest {

    @Autowired
    public LibraryApi libraryApi;

    @PutMapping("/create")
    public void createNewLibrary(@RequestBody Library library) {
        libraryApi.createNewLibrary(library);
    }


}
