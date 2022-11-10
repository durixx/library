package sk.durixx.library.domain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.durixx.library.model.dto.RackDto;
import sk.durixx.library.model.entity.Rack;
import sk.durixx.library.repository.RackRepository;

import java.util.List;

@Service
public class RackService {

    @Autowired
    public RackRepository rackRepository;

    public Rack createNewRack(RackDto rack) {
        validateRack(Rack.fromDto(rack));
        return rackRepository.save(Rack.fromDto(rack));
    }


    public Rack readRack(Long id) {
        return rackRepository.findById(id).orElseThrow();
    }

    public Rack updateRack(Rack rack) {
       return rackRepository.save(rack);
    }

    public void deleteRack(Long id) {
        rackRepository.delete(rackRepository.getReferenceById(id));
    }

    public List<Rack> readAll() {
        return rackRepository.findAll();
    }

    public void patchRack(Rack rack, Long id) {
        Rack loadRack = rackRepository.getReferenceById(id);

        if(rack.getSize() != 0) loadRack.setSize(rack.getSize());

        rackRepository.save(loadRack);
    }

    private void validateRack(Rack rack) {
        if (rack.getSize() == 0) throw new IllegalArgumentException("size must be greater than 0");
    }
}
