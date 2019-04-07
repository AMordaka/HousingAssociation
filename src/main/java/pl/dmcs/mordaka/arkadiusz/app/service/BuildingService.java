package pl.dmcs.mordaka.arkadiusz.app.service;

import pl.dmcs.mordaka.arkadiusz.app.model.Building;

import java.util.List;

public interface BuildingService {

    List<Building> getAllBuildings();

    void registerBuilding(Building building);

    Building findById(Integer id);
}
