package com.practiceAPI4.practice4RestAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*  we need versioning of rest-api to manage changes in an API over time, it allow
        backward compatibility and minimizing disruptions for existing API consumers
        we have 4 way to do versioning:
        1-URL versioning was used in twiter
        2-request params was used in Amazon
        3-Header versioning was Microsoft
        4-Media type was used in github
       */
@RestController
public class apiVersioning {
   /* here is an example of url versioning
      in v1 we need a person info like name and last name
      like this name ="Khan Wardak"
    */

    @GetMapping("api/v1/person")
    public PersonV1 urlVesioningFirstVersion(){
        return new PersonV1("Khan Wardak");
    }

    /* here we need to change the to return person info
       like this name ="khan" and lastname="wardak"
       this version 2 api that we needed
     */
    @GetMapping("api/v2/person")
    public PersonV2 urlVesioningScondVersion(){
        return new PersonV2("Khan","Wardak");
    }

    /* here we do request param url versioning based on
       person information
     */
    @GetMapping(path = "/person", params = "version1")
    public PersonV1 requestParamVesioningFirstVersion(){
        return new PersonV1("Khan Wardak");
    }

    // here we need to change the api to version2

    @GetMapping(path = "person", params = "version2")
    public PersonV2 requestVesioningScondVersion(){
        return new PersonV2("Khan","Wardak");
    }

    // here we do Header url versioning

    @GetMapping(path = "/person", headers = "api-version=1")
    public PersonV1 headerVesioningFirstVersion(){
        return new PersonV1("Khan Wardak");
    }

    // version 2 of the header versioning
    @GetMapping(path = "person", headers = "api-version=2")
    public PersonV2 headerVesioningScondVersion(){
        return new PersonV2("Khan","Wardak");
    }
    // here is the version1 of media type versioning
    @GetMapping(path = "/person", produces = "application/v.app-v1+json")
    public PersonV1 mediaTypeVesioningFirstVersion(){
        return new PersonV1("Khan Wardak");
    }

    // here is the version2 of media type versioning
    @GetMapping(path = "person",produces ="application/v.app-v2+json")
    public PersonV2 mediaTypeVesioningScondVersion(){
        return new PersonV2("Khan","Wardak");
    }

}
