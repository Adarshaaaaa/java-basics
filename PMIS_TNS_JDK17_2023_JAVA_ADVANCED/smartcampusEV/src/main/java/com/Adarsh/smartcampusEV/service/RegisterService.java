package com.Adarsh.smartcampusEV.service;

import com.Adarsh.smartcampusEV.model.Shuttlees;
import com.Adarsh.smartcampusEV.model.Status;
import com.Adarsh.smartcampusEV.repository.ShuttleEV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegisterService {

    @Autowired
    ShuttleEV shut;

    public void register(Shuttlees shuttle){
        shut.save(shuttle);
    }

    public List<Shuttlees> getAvail(){
        return shut.findAll()
                .stream()
                .filter(sh-> sh.getStatus()== Status.AVAILABLE)
                .filter(sh-> sh.getBattery_pct()>20)
                .collect(Collectors.toList());
    }

}
