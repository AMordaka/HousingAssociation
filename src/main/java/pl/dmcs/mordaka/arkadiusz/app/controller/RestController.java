package pl.dmcs.mordaka.arkadiusz.app.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.dmcs.mordaka.arkadiusz.app.model.Charge;
import pl.dmcs.mordaka.arkadiusz.app.service.ChargeService;

import java.util.List;

@Controller
@RequestMapping("/")
public class RestController {

    private final ChargeService chargeService;

    public RestController(ChargeService chargeService) {
        this.chargeService = chargeService;
    }

    @Secured("ROLE_ADMIN")
    @GetMapping(value = "/rest", produces = "application/json")
    public @ResponseBody
    List<Charge> getAllCharges() {
        return chargeService.getAllCharges();
    }

}
