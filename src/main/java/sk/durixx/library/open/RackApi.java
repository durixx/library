package sk.durixx.library.open;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sk.durixx.library.domain.LibraryService;
import sk.durixx.library.domain.RackService;
import sk.durixx.library.model.dto.RackDto;
import sk.durixx.library.model.entity.Library;
import sk.durixx.library.model.entity.Rack;

import java.util.List;

@Component
public class RackApi {

    @Autowired
    public RackService rackService;
    @Autowired
    public LibraryService libraryService;

    public void createNewRack(Long idOfLibrary, RackDto rackDto) {
        Rack rackWithId = rackService.createNewRack(rackDto);
        Library libraryToEdit = libraryService.readLibrary(idOfLibrary);
        libraryToEdit.getRackList().add(rackWithId);
        libraryService.patchLibrary(libraryToEdit, libraryToEdit.getId());
    }

    public RackDto readRack(Long id) {
        return RackDto.fromRack(rackService.readRack(id));
    }

    public void updateRack(RackDto rackDto) {
        rackService.updateRack(Rack.fromDto(rackDto));
    }

    public void deleteRack(Long id) {
        rackService.deleteRack(id);
    }

    public List<RackDto> readAll() {
        return rackService.readAll()
                .stream()
                .map(RackDto::fromRack)
                .toList();
    }

    public void patchRack(RackDto rackDto, Long id) {
        rackService.patchRack(Rack.fromDto(rackDto), id);
    }
}
