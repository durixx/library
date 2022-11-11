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

    public RackDto readRack(Long libraryId, Long id) {
        return RackDto.fromRack(rackService.readRack(libraryId, id));
    }

    public void updateRack(Long libraryId, RackDto rackDto) {
        rackService.updateRack(libraryId, Rack.fromDto(rackDto));
    }

    public void deleteRack(Long libId, Long id) {
        rackService.deleteRack(libId, id);
    }

    public List<RackDto> readAll() {
        return rackService.readAll()
                .stream()
                .map(RackDto::fromRack)
                .toList();
    }

    public void patchRack(Long libraryId, RackDto rackDto, Long id) {
        rackService.patchRack(libraryId, Rack.fromDto(rackDto), id);
    }

    public String getLabel(Long libraryId) {
        return libraryService.getLabel(libraryId);
    }
}
