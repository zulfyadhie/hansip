package com.dpbg.hansip.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zulfyadhie on 2/12/17.
 */
@RestController
public class IndexController {

    @RequestMapping(value = "/home")
    public String index(){
        return "ok";
    }

}