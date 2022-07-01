package com.sarim.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("filtering")
    public MappingJacksonValue retrieveSomeBean(){
        SomeBean someBean = new SomeBean("value1", "value2", "value3");


        //Dynamic filtering  of single object
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");

        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter); //Use id in bean as -> @JsonFilter("SomeBeanFilter")

        MappingJacksonValue mapping = new MappingJacksonValue(someBean); //Relating to some object - try for different objects
        mapping.setFilters(filters);

        //Dynamic filtering

        return mapping;
    }

    @GetMapping("filtering-list")
    public MappingJacksonValue retrieveListOfSomeBean(){
        SomeBean someBean1 = new SomeBean("value1", "value2", "value3");
        SomeBean someBean2 = new SomeBean("value12", "value22", "value32");

        List<SomeBean> list = Arrays.asList(someBean1, someBean2);


        //Dynamic filtering of list of objects
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1");

        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);

        MappingJacksonValue mapping = new MappingJacksonValue(list);
        mapping.setFilters(filters);
        //Dynamic filtering of list of objects



        return mapping;
    }

}
