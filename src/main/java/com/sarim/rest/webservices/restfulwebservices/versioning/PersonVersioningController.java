package com.sarim.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    @GetMapping("/v1/person")
    public PersonV1 PersonV1(){
        return new PersonV1("Sarim Zafar");
    }

    @GetMapping("/v2/person")
    public PersonV2 PersonV2(){
        return new PersonV2(new Name("Sarim","Zafar"));
    }

}
