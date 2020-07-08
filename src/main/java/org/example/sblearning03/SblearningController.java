package org.example.sblearning03;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SblearningController {

    @RequestMapping(value = "/")
    public String doGet()
    {
        return "Hello Spring World !!! it is deployed in DevOps !!!!";
    }
}
