package com.Adarsh.smartcampusEV.model;

import jakarta.persistence.*;

@Entity
public class Routes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int route_id;
    @Column(name="stop_name",nullable = false,length = 100)
    private String stop_name;
    @Column(name="sequence_order",nullable = false)
    private int sequence_order;
    @Column(name="status",nullable = false)
    private Status status;

    public Routes(){}
    public Routes(String stop_name,int sequence_order){
        this.stop_name=stop_name;
        this.sequence_order=sequence_order;

    }

    public String getStop_name() {
        return stop_name;
    }

    public void setStop_name(String stop_name) {
        this.stop_name = stop_name;
    }

    public int getRoute_id() {
        return route_id;
    }

    public void setRoute_id(int route_id) {
        this.route_id = route_id;
    }

    public int getSequence_order() {
        return sequence_order;
    }

    public void setSequence_order(int sequence_order) {
        this.sequence_order = sequence_order;
    }

}
