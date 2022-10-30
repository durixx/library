package sk.durixx.library.data.loader;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sk.durixx.library.model.dto.LibraryDto;
import sk.durixx.library.model.entity.Library;
import sk.durixx.library.open.LibraryApi;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader {

    @Autowired
    private LibraryApi libraryApi;

    @PostConstruct
    public void loadData() {
        LibraryDto lib1 = new LibraryDto();
        lib1.setNameOfLibrary("Lib1");
        lib1.setAddress("Malinova");
        lib1.setCity("Poprad");
        lib1.setCountry("Nemecko");


        LibraryDto lib2 = new LibraryDto();
        lib2.setNameOfLibrary("Lib2");
        lib2.setAddress("Jahodova");
        lib2.setCity("Koice");
        lib2.setCountry("Slovensko");


        LibraryDto lib3 = new LibraryDto();
        lib3.setNameOfLibrary("Lib3");
        lib3.setAddress("Horska");
        lib3.setCity("Presov");
        lib3.setCountry("Polsko");

        libraryApi.createNewLibrary(lib1);
        libraryApi.createNewLibrary(lib2);
        libraryApi.createNewLibrary(lib3);
    }





}
