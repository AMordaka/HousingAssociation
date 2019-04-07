package pl.dmcs.mordaka.arkadiusz.app.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.dmcs.mordaka.arkadiusz.app.model.Building;
import pl.dmcs.mordaka.arkadiusz.app.service.BuildingService;

@Component
public class BuildingToBuildingView implements Converter<Object, Building> {

    private static final Logger logger = LoggerFactory.getLogger(BuildingToBuildingView.class);

    private final BuildingService buildingService;

    public BuildingToBuildingView(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    @Override
    public Building convert(Object element) {
        Integer id = Integer.parseInt((String) element);
        Building building = buildingService.findById(id);
        logger.info("Building : {}", building);
        return building;
    }
}
