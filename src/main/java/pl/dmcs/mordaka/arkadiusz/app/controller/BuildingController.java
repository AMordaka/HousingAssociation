package pl.dmcs.mordaka.arkadiusz.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.dmcs.mordaka.arkadiusz.app.model.Building;
import pl.dmcs.mordaka.arkadiusz.app.service.BuildingService;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class BuildingController {

    private static final String LIST_OF_BUILDINGS = "list_of_buildings";
    private static final String ADD_BUILDING = "add_building";
    private static final String REDIRECT_HOMEPAGE = "redirect:/";

    private final BuildingService buildingService;

    public BuildingController(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    @RequestMapping(value = "/buildings", method = RequestMethod.GET)
    public String listOfUsers(ModelMap model) {
        model.addAttribute("building", new Building());
        model.addAttribute("buildings", buildingService.getAllBuildings());
        return LIST_OF_BUILDINGS;
    }

    @RequestMapping(value = "/addbuilding", method = RequestMethod.GET)
    public String addBuildingPage(ModelMap model) {
        model.addAttribute("building", new Building());
        return ADD_BUILDING;
    }

    @RequestMapping(value = "/addbuilding", method = RequestMethod.POST)
    public String addBuildingPost(@Valid Building building, BindingResult result) {
        if (result.hasErrors()) {
            return ADD_BUILDING;
        }
        buildingService.registerBuilding(building);
        return REDIRECT_HOMEPAGE;
    }
}
