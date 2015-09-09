package com.pineone.sda.controller;

import com.pineone.sda.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.lang.String;

/**
 * Created by use on 2015-09-04.
 */
@Controller
public class SDAController {

    @Autowired
    DataService dataService;

    @RequestMapping(value = "/context/{name}", method = RequestMethod.GET )
    public @ResponseBody String RecevieData(@PathVariable String name){

        return dataService.ContextAwareness(name).toJSONString();
    }

}
