package sk.durixx.library.data.loader;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sk.durixx.library.model.dto.LibraryDto;
import sk.durixx.library.model.entity.Library;
import sk.durixx.library.open.LibraryApi;

@Component
public class DataLoader {

    @Autowired
    private LibraryApi libraryApi;

    @PostConstruct
    public void loadData() {
        libraryApi.createNewLibrary(LibraryDto.withBuilder("Lib1", "Malinova", "Poprad","Slovakia"));
        libraryApi.createNewLibrary(LibraryDto.withBuilder("Lib2", "Jahodova", "Koice","Nemecko"));
        libraryApi.createNewLibrary(LibraryDto.withBuilder("Lib3", "Horska", "Presov","Polsko"));
    }
}
