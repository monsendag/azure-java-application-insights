package no.mesan.clouddevops.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/throwexception")
public class ExceptionController {

    @RequestMapping(method = RequestMethod.GET)
    public void throwException() {
        throw new RuntimeException("An expected exception has occured ;-)");
    }
}
