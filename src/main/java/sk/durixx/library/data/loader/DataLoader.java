package sk.durixx.library.data.loader;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sk.durixx.library.model.dto.LibraryDto;
import sk.durixx.library.model.dto.RackDto;
import sk.durixx.library.open.LibraryApi;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader {

    @Autowired
    private LibraryApi libraryApi;

    @PostConstruct
    public void loadData() {

        List<RackDto> rackList = new ArrayList<>();

        LibraryDto lib1 = new LibraryDto();
        lib1.setNameOfLibrary("Lib1");
        lib1.setAddress("Malinova");
        lib1.setCity("Poprad");
        lib1.setCountry("Nemecko");
        lib1.setRackList(rackList);



        LibraryDto lib2 = new LibraryDto();
        lib2.setNameOfLibrary("Lib2");
        lib2.setAddress("Jahodova");
        lib2.setCity("Koice");
        lib2.setCountry("Slovensko");
        lib2.setRackList(rackList);


        LibraryDto lib3 = new LibraryDto();
        lib3.setNameOfLibrary("Lib3");
        lib3.setAddress("Horska");
        lib3.setCity("Presov");
        lib3.setCountry("Polsko");
        lib3.setRackList(rackList);




        libraryApi.createNewLibrary(lib1);
        libraryApi.createNewLibrary(lib2);
        libraryApi.createNewLibrary(lib3);
    }





}
