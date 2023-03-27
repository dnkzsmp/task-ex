package com.example.server1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
    @RequestMapping(value = "/firstLongURLFromServer1", method = RequestMethod.GET)
    @ResponseBody
    public String first() {
        return "Server1, firstLongURLFromServer1";
    }

    @RequestMapping(value = "/secondLongURLFromServer1", method = RequestMethod.GET)
    @ResponseBody
    public String second() {
        return "Server1, secondLongURLFromServer1";
    }
}
