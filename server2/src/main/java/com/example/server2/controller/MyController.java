package com.example.server2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
    @RequestMapping(value = "/firstLongURLFromServer2", method = RequestMethod.GET)
    @ResponseBody
    public String first() {
        return "Server2, firstLongURLFromServer2";
    }

    @RequestMapping(value = "/secondLongURLFromServer2", method = RequestMethod.GET)
    @ResponseBody
    public String second() {
        return "Server2, secondLongURLFromServer2";
    }
}
