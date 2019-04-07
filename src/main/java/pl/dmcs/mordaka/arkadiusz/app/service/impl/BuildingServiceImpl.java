package pl.dmcs.mordaka.arkadiusz.app.service.impl;

import org.springframework.stereotype.Service;
import pl.dmcs.mordaka.arkadiusz.app.exception.BuildingNotFoundException;
import pl.dmcs.mordaka.arkadiusz.app.model.Building;
import pl.dmcs.mordaka.arkadiusz.app.repository.BuildingRepository;
import pl.dmcs.mordaka.arkadiusz.app.service.BuildingService;

import java.util.List;

@Service
public class BuildingServiceImpl implements BuildingService {

    private final BuildingRepository buildingRepository;

    public BuildingServiceImpl(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    @Override
    public List<Building> getAllBuildings() {
        return buildingRepository.findAll();
    }

    @Override
    public void registerBuilding(Building building) {
        buildingRepository.save(building);
    }

    @Override
    public Building findById(Integer id) {
        return buildingRepository.findById(id).orElseThrow(() -> new BuildingNotFoundException(String.valueOf(id)));
    }
}
