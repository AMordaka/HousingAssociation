package pl.dmcs.mordaka.arkadiusz.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.dmcs.mordaka.arkadiusz.app.model.Building;
import pl.dmcs.mordaka.arkadiusz.app.service.BuildingService;
import pl.dmcs.mordaka.arkadiusz.app.service.LocalService;

@Controller
@RequestMapping("/")
public class LocalController {

    private static final String LIST_OF_LOCALS = "list_of_locals";

    private final LocalService localService;
    private final BuildingService buildingService;

    public LocalController(LocalService localService, BuildingService buildingService) {
        this.localService = localService;
        this.buildingService = buildingService;
    }

    @RequestMapping(value = "/locals", method = RequestMethod.GET)
    public String listOfUsers(ModelMap model) {
        model.addAttribute("locals", localService.getAllLocals());
        return LIST_OF_LOCALS;
    }

    @RequestMapping(value = "/locals-{buildingId}", method = RequestMethod.GET)
    public String getAllLocalsFromBuildingId(@PathVariable String buildingId, ModelMap model) {
        Building building = buildingService.findById(Integer.valueOf(buildingId));
        model.addAttribute("locals", building.getLocals());
        return LIST_OF_LOCALS;
    }
}
