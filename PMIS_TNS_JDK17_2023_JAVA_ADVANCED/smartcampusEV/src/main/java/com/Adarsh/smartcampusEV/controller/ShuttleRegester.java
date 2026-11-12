package com.Adarsh.smartcampusEV.controller;

import com.Adarsh.smartcampusEV.model.Shuttlees;
import com.Adarsh.smartcampusEV.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShuttleRegester {

    @Autowired
    RegisterService service;
    @PostMapping("/reg")

    public void registerResponse( @RequestBody Shuttlees shuttle){
      service.register(shuttle);

    }
    @GetMapping("/re")
    public List<Shuttlees> getAvailable(){
        return service.getAvail();
    }
}
