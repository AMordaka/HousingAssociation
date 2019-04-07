package pl.dmcs.mordaka.arkadiusz.app.exception;

import pl.dmcs.mordaka.arkadiusz.app.model.Building;

public class BuildingNotFoundException extends AbstractNotFoundException {

    public BuildingNotFoundException(String code) {
        super(Building.class, code);
    }
}
