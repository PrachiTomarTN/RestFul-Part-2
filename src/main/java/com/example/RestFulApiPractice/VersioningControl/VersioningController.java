package com.example.RestFulApiPractice.VersioningControl;

import com.example.RestFulApiPractice.Entities.Person;
import com.example.RestFulApiPractice.Entities.Person1;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {

    // URI Versnoning
    @GetMapping("/person")
    public Person URIversoning(){
        return new Person("Prachi Tomar");
    }
    @GetMapping("/person1")
    public Person1 URIversoning1(){
        return new Person1("Prachi","Tomar");
    }

    //Header Versioning
    @GetMapping(path="/person/header",headers = "X-API-VERSION=1")
    public Person RequestParameterV(){
        return new Person("Prachi Tomar");
    }

    @GetMapping(path="/person/header",headers = "X-API-VERSION=2")
    public Person1 RequestParameterV2(){
        return new Person1("Prachi","Tomar");
    }

    //REquest Parameter
    @GetMapping(value = "/person",params = "version1")
    public Person PersonByUsingParams(){
        return new Person("Prachi Tomar");
    }

    @GetMapping(value = "/person",params = "version2")
    public Person1 person1ByUsingParams(){
        return new Person1("Prachi","Tomar");
    }

    //Media Versioning
    @GetMapping(path="/person/accept",produces = "application/vnd.company.app-v1+json")
    public Person MediaVersoning(){
        return new Person("Prachi Tomar");
    }

    @GetMapping(path="/person/accept",produces = "application/vnd.company.app-v2+json")
    public Person1 MediaVersoning1(){
        return new Person1("Prachi","Tomar");
    }

}
