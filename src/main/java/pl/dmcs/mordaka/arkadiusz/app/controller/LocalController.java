package pl.dmcs.mordaka.arkadiusz.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.dmcs.mordaka.arkadiusz.app.model.Charge;
import pl.dmcs.mordaka.arkadiusz.app.model.DTO.UserLocalDTO;
import pl.dmcs.mordaka.arkadiusz.app.model.Local;
import pl.dmcs.mordaka.arkadiusz.app.service.BuildingService;
import pl.dmcs.mordaka.arkadiusz.app.service.LocalService;
import pl.dmcs.mordaka.arkadiusz.app.service.UserService;

import javax.validation.Valid;

@Controller
@SessionAttributes("visible")
@RequestMapping("/")
public class LocalController {

    private static final String LIST_OF_LOCALS = "list_of_locals";
    private static final String ADD_LOCAL = "add_local";
    private static final String REDIRECT_HOMEPAGE = "redirect:/";
    private static final String ASSIGN_LOCAL_TO_USER = "assign_local_to_user";
    private static final String ADD_CHARGE = "add_charge";

    private final LocalService localService;
    private final BuildingService buildingService;
    private final UserService userService;

    public LocalController(LocalService localService, BuildingService buildingService, UserService userService) {
        this.localService = localService;
        this.buildingService = buildingService;
        this.userService = userService;
    }

    @RequestMapping(value = "/locals", method = RequestMethod.GET)
    public String getListOfLocals(ModelMap model) {
        model.addAttribute("locals", localService.getAllLocals());
        return LIST_OF_LOCALS;
    }

    @RequestMapping(value = "/locals-{buildingId}", method = RequestMethod.GET)
    public String getAllLocalsFromBuildingId(@PathVariable String buildingId, ModelMap model) {
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
        model.addAttribute("users", userService.getActivatedUsers());
        model.addAttribute("locals", localService.getNotRentedLocals());
        model.addAttribute("dto", new UserLocalDTO());
        return ASSIGN_LOCAL_TO_USER;
    }

    @RequestMapping(value = "/assign", method = RequestMethod.POST)
    public String assignPost(@Valid UserLocalDTO dto) {
        userService.assignUserToLocal(dto);
        return REDIRECT_HOMEPAGE;
    }

    @RequestMapping(value = "/charge-{localId}", method = RequestMethod.GET)
    public String chargesPage(@PathVariable Integer localId, ModelMap model) {
        model.addAttribute("charge", new Charge());
        return ADD_CHARGE;
    }

    @RequestMapping(value = "/confirmCharge-{localId}", method = RequestMethod.GET)
    public String confirmChargePage(@PathVariable Integer localId, ModelMap model) {
        model.addAttribute("charge", localService.findLatestChargeFromLocal(localId));
        return ADD_CHARGE;
    }

    @RequestMapping(value = "/confirmCharge-{localId}", method = RequestMethod.POST)
    public String confirmChargePost(@PathVariable Integer localId, @Valid Charge charge) {
        localService.confirmCharges(localId, charge);
        return REDIRECT_HOMEPAGE;
    }

    @RequestMapping(value = "/charge-{localId}", method = RequestMethod.POST)
    public String chargesPost(@PathVariable Integer localId, @Valid Charge charge) {
        localService.fillLocalCharge(localId, charge);
        return REDIRECT_HOMEPAGE;
    }

    @RequestMapping(value = "/mylocals", method = RequestMethod.GET)
    public String myLocalsPage(ModelMap model) {
        model.addAttribute("locals", localService.getUserLocals(userService.getPrincipal()));
        return LIST_OF_LOCALS;
    }

    @RequestMapping(value = "/generateAmounts", method = RequestMethod.GET)
    public String generateAmountsPage(ModelMap model) {
        localService.generateAmounts();
        return REDIRECT_HOMEPAGE;
    }

    @RequestMapping(value = "/acceptAllChanges", method = RequestMethod.GET)
    public String acceptAllChangesPage() {
        localService.acceptAllCharges();
        return REDIRECT_HOMEPAGE;
    }
}
