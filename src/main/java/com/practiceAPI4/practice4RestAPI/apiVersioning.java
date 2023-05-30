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
}
