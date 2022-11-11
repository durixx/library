package sk.durixx.library.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.durixx.library.model.dto.RackDto;
import sk.durixx.library.model.entity.Library;
import sk.durixx.library.model.entity.Rack;
import sk.durixx.library.repository.RackRepository;

import java.util.List;

@Service
public class RackService {

    private static final String RACK_NOT_IN_LIBRARY  = "Rack is not found under selected library";
    @Autowired
    public RackRepository rackRepository;
    @Autowired
    public LibraryService libraryService;


    public Rack createNewRack(RackDto rack) {
        validateRack(Rack.fromDto(rack));
        return rackRepository.save(Rack.fromDto(rack));
    }

    public List<Rack> readAll() {
        return rackRepository.findAll();
    }

    public Rack readRack(Long libraryId, Long id) {
        if (libraryService.isRackBelongsToLibrary(libraryId, id)) {
            return rackRepository.findById(id).orElseThrow();
        } else throw new IllegalArgumentException(RACK_NOT_IN_LIBRARY);
    }

    public Rack updateRack(Long libraryId, Rack rack) {
        if (libraryService.isRackBelongsToLibrary(libraryId, rack.getId())) {
            return rackRepository.save(rack);
        } else throw new IllegalArgumentException(RACK_NOT_IN_LIBRARY);
    }

    public void deleteRack(Long libId, Long id) {
        if (libraryService.isRackBelongsToLibrary(libId, id)) {
            removeRackFromLibrary(libId, id);
            rackRepository.delete(rackRepository.getReferenceById(id));
        } else throw new IllegalArgumentException(RACK_NOT_IN_LIBRARY);
    }

    public void patchRack(Long library, Rack rack, Long id) {
        if (libraryService.isRackBelongsToLibrary(library, id)) {
            Rack loadRack = rackRepository.getReferenceById(id);
            if (rack.getSize() != 0) loadRack.setSize(rack.getSize());
            rackRepository.save(loadRack);
        } else throw new IllegalArgumentException(RACK_NOT_IN_LIBRARY);
    }

    private void removeRackFromLibrary(Long libId, Long rackId) {
        Library tempLibrary = libraryService.readLibrary(libId);
        tempLibrary.getRackList().remove(rackRepository.getReferenceById(rackId));
        libraryService.updateLibrary(tempLibrary);
    }

    private void validateRack(Rack rack) {
        if (rack.getSize() == 0) throw new IllegalArgumentException("size must be greater than 0");
    }
}
