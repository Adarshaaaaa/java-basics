package com.Adarsh.smartcampusEV.model;

import jakarta.persistence.*;

@Entity
public class Shuttlees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shutle_id")
    private int shuttle_id;
    @Column(name="driver_name",nullable = false,length = 100)
    private String driver_name;
    @Column(name="battery_pct",nullable=false)
    private int battery_pct;
    private Status status;
public Shuttlees(){}
    public Shuttlees(String driver_name,int battery_pct,Status status){

        this.driver_name=driver_name;
        this.battery_pct=battery_pct;
        this.status=status;
    }

    public int getShuttle_id() {
        return shuttle_id;
    }

    public void setShuttle_id(int shuttle_id) {
        this.shuttle_id = shuttle_id;
    }

    public String getDriver_name() {
        return driver_name;
    }

    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
    }

    public int getBattery_pct() {
        return battery_pct;
    }

    public void setBattery_pct(int battery_pct) {
        this.battery_pct = battery_pct;
    }
    public Status getStatus(){
        return status;
    }
    public void setStatus(Status status){
        this.status=status;
    }

}
