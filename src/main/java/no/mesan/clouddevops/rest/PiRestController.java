package no.mesan.clouddevops.rest;

import no.mesan.clouddevops.service.PiCalculator;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(value = "/api/pi")
public class PiRestController {

   @RequestMapping(value = "/{decimals}", method = GET)
    public BigDecimal delete(@PathVariable final int decimals) {
        // regn ut variabler for pi
        return PiCalculator.pi(decimals);
    }

}
