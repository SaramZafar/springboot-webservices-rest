package com.sarim.rest.webservices.restfulwebservices.filtering;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(value= {"field1"})    //Another way of filtering attributes - hard coded not recommended
@JsonFilter("SomeBeanFilter")
public class SomeBean {


    private String field1;

    //@JsonIgnore //To ignore this field to be sent back to as a part of response to client
    private String field2;

    //@JsonIgnore //@JsonIgnore //To ignore this field to be sent back to as a part of response to client
    private String field3;

    public SomeBean() {
    }

    public SomeBean(String field1, String field2, String field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    public String getField1() {
        return field1;
    }

    public String getField2() {
        return field2;
    }


    public String getField3() {
        return field3;
    }
}
