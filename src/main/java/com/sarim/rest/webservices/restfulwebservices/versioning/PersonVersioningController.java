package com.sarim.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    //URI - versioning      -       Poluting URI
    @GetMapping("/v1/person")
    public PersonV1 PersonV1(){
        return new PersonV1("Sarim Zafar");
    }

    @GetMapping("/v2/person")
    public PersonV2 PersonV2(){
        return new PersonV2(new Name("Sarim","Zafar"));
    }
    //URI - versioning


    //Request param - versioning        -        Poluting URI
    @GetMapping(value="/param", params = "version=1")
    public PersonV1 paramV1(){
        return new PersonV1("Sarim Zafar");
    }

    @GetMapping(value="/param", params = "version=2")
    public PersonV2 paramV2(){
        return new PersonV2(new Name("Sarim","Zafar"));
    }

    //Request param - versioning


    //Header- versioning        -   Missuse of HTTP headers
    @GetMapping(value="person/header", headers = "X-API-VERSION=1")
    public PersonV1 headerV1(){
        return new PersonV1("Sarim Zafar");
    }

    @GetMapping(value="person/header", headers = "X-API-VERSION=2")
    public PersonV2 headerV2(){
        return new PersonV2(new Name("Sarim","Zafar"));
    }

    //Header - versioning


    //Producers/Accept header/ Mine-type  - versioning      -   Missuse of HTTP headers
    @GetMapping(value="person/produces", produces = "application/vnd.company.app-v1+json")
    public PersonV1 producesV1(){
        return new PersonV1("Sarim Zafar");
    }

    @GetMapping(value="person/produces", produces = "application/vnd.company.app-v2+json")
    public PersonV2 producesV2(){
        return new PersonV2(new Name("Sarim","Zafar"));
    }

    //Producers/Accept header/ Mine-type  - versioning

}
