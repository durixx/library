package sk.durixx.library.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.durixx.library.model.dto.RackDto;
import sk.durixx.library.open.RackApi;

import java.util.List;


@RestController
@RequestMapping("api/rack")
public class RackRest {

    @Autowired
    public RackApi rackApi;

    @PostMapping("/{libId}")
    public void createNewRack(@PathVariable Long libId, @RequestBody RackDto rackDto) {
        rackApi.createNewRack(libId, rackDto);
    }

    @GetMapping("/{libId}/{id}")
    public RackDto readRack(@PathVariable Long libId, @PathVariable Long id) {
        return rackApi.readRack(libId, id);
    }

    @PutMapping("/{libId}")
    public void updateRack(@PathVariable Long libId, @RequestBody RackDto rackDto) {
        rackApi.updateRack(libId, rackDto);
    }

    @DeleteMapping("/{libId}/{id}")
    public void deleteRack(@PathVariable Long libId, @PathVariable Long id) {
        rackApi.deleteRack(libId, id);
    }

    @GetMapping("/all")
    public List<RackDto> readAll() {
        return rackApi.readAll();
    }

    @PatchMapping("/{libId}/{id}")
    public void patchRack(@PathVariable Long libId, @RequestBody RackDto rackDto, @PathVariable Long id) {
        rackApi.patchRack(libId, rackDto, id);
    }

    @GetMapping("/{libraryId}/unique-identifier")
    public String getLabel(@PathVariable Long libraryId) {
        return rackApi.getLabel(libraryId);
    }
}
