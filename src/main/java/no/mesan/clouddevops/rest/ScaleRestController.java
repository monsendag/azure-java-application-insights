package no.mesan.clouddevops.rest;

import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(value = "/api/scale")
public class ScaleRestController {

   @RequestMapping(value = "/{decimals}", method = GET)
    public void delete(@PathVariable final Long decimals) {
        // regn ut variabler for pi




    }


}
