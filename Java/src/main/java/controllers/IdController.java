package controllers;

import hibernate.model.Aircraft;
import hibernate.model.Airport;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IdController {

    @Autowired

    @GetMapping(value = "")
    String index() {
        return "index";
    }


    @PostMapping(value = "generateModel", produces = MediaType.TEXT_PLAIN_VALUE)
    public String generateModel() {

        DateTime dateAndTime  = DateTime.now();

        Airport a1 = new Airport("POZ", 94);

        Aircraft au1 = new Aircraft("fighter","McDonnell Douglas","PL8689","F-15");

        return "Model Generated";
    }
}