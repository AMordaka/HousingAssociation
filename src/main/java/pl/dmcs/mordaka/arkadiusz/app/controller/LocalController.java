package pl.dmcs.mordaka.arkadiusz.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.dmcs.mordaka.arkadiusz.app.model.DTO.UserLocalDTO;
import pl.dmcs.mordaka.arkadiusz.app.model.Local;
import pl.dmcs.mordaka.arkadiusz.app.service.BuildingService;
import pl.dmcs.mordaka.arkadiusz.app.service.LocalService;
import pl.dmcs.mordaka.arkadiusz.app.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class LocalController {

    private static final String LIST_OF_LOCALS = "list_of_locals";
    private static final String ADD_LOCAL = "add_local";
    private static final String REDIRECT_HOMEPAGE = "redirect:/";
    private static final String ASSIGN_LOCAL_TO_USER = "assign_local_to_user";

    private final LocalService localService;
    private final BuildingService buildingService;
    private final UserService userService;

    public LocalController(LocalService localService, BuildingService buildingService, UserService userService) {
        this.localService = localService;
        this.buildingService = buildingService;
        this.userService = userService;
    }

    @RequestMapping(value = "/locals", method = RequestMethod.GET)
    public String listOfUsers(ModelMap model) {
        model.addAttribute("usersForModal", userService.getAllUsers());
        model.addAttribute("locals", localService.getAllLocals());
        return LIST_OF_LOCALS;
    }

    @RequestMapping(value = "/locals-{buildingId}", method = RequestMethod.GET)
    public String getAllLocalsFromBuildingId(@PathVariable String buildingId, ModelMap model) {
        model.addAttribute("usersForModal", userService.getAllUsers());
        model.addAttribute("locals", buildingService.getLocalsFromBuilding(Integer.valueOf(buildingId)));
        return LIST_OF_LOCALS;
    }

    @RequestMapping(value = "/addlocal", method = RequestMethod.GET)
    public String addLocalPage(ModelMap model) {
        model.addAttribute("local", new Local());
        model.addAttribute("buildings", buildingService.getAllBuildings());
        return ADD_LOCAL;
    }

    @RequestMapping(value = "/addlocal", method = RequestMethod.POST)
    public String addLocalPost(@Valid Local local, BindingResult result) {
        if (result.hasErrors()) {
            return ADD_LOCAL;
        }
        localService.registerLocal(local);
        return REDIRECT_HOMEPAGE;
    }

    @RequestMapping(value = "/assign", method = RequestMethod.GET)
    public String assignPage(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("locals", localService.getAllLocals());
        model.addAttribute("dto", new UserLocalDTO());
        return ASSIGN_LOCAL_TO_USER;
    }

    @RequestMapping(value = "/assign", method = RequestMethod.POST)
    public String assignPost(@Valid UserLocalDTO dto) {
        userService.assignUserToLocal(dto);
        return REDIRECT_HOMEPAGE;
    }
}
