package com.pineone.sda.controller;

import com.pineone.sda.service.DataService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by use on 2015-09-04.
 */
@Controller
public class SDAController {

    @Autowired
    DataService dataService;

    @ResponseBody
    @RequestMapping(value = "/context/{name}", method = RequestMethod.GET )
    public JSONObject RecevieData(@PathVariable String name){

        return dataService.ContextAwareness(name);
    }

    @ResponseBody
    @RequestMapping(value = "/si/command", method = RequestMethod.POST)
    public JSONObject DeviceCommand(@RequestBody JSONObject jsonObject){


        // 받은 데이터 출력.
        System.out.println("Request Json data message");
        System.out.println(jsonObject.toJSONString());

        // 결과값 json으로 전달.
        JSONObject object = new JSONObject();
        object.put("code","200");
        object.put("message","Success");
        object.put("content",jsonObject);

        // 결과값 json으로 전달 및 content 데이터에 전달 받은값 뿌림.

        return object;
    }

    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.POST )
    public JSONObject RecevieData(@RequestBody JSONObject jsonObject){
        System.out.println(jsonObject);
        return dataService.ContextAwareness("aaa");
    }

}
