package pl.dmcs.mordaka.arkadiusz.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.dmcs.mordaka.arkadiusz.app.service.LocalService;
import pl.dmcs.mordaka.arkadiusz.app.service.PdfService;

@Controller
@RequestMapping("/")
public class PdfController {

    private static final String REDIRECT_HOMEPAGE = "redirect:/";

    private final LocalService localService;
    private final PdfService pdfService;

    public PdfController(LocalService localService, PdfService pdfService) {
        this.localService = localService;
        this.pdfService = pdfService;
    }

    @RequestMapping(value = "/generatePdf-{localId}", method = RequestMethod.GET)
    public String confirmChargePage(@PathVariable Integer localId, ModelMap model) {
        pdfService.generatePdf(localService.getLocalById(localId));
        return REDIRECT_HOMEPAGE;
    }


}
