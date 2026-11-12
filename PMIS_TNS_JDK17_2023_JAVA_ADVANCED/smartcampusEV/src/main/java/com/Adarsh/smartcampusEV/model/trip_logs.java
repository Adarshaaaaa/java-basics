package com.Adarsh.smartcampusEV.model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Entity
public class trip_logs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int log_id;
    @ManyToOne
    @JoinColumn(name="shuttle_id",nullable = false)
    private Shuttlees shuttle_id;
    @ManyToOne
    @JoinColumn(name="route_id",nullable = false)
    private Routes route_id;
    @Column(name="passengers_boarded",nullable = false)
    private int passengers_boarded;
    @Column(name="trip_timestamp")
    private LocalDateTime trip_timestamp;

    public trip_logs() {
    }

    public trip_logs(Shuttlees shuttle_id,Routes route_id,int passengers_boarded, LocalDateTime trip_timestamp) {
        this.shuttle_id = shuttle_id;
        this.route_id=route_id;
        this.passengers_boarded=passengers_boarded;
        this.trip_timestamp=trip_timestamp;
    }

    public Shuttlees getShuttle_id() {
        return shuttle_id;
    }

    public void setShuttle_id(Shuttlees shuttle_id) {
        this.shuttle_id = shuttle_id;
    }

    public Routes getRoute_id() {
        return route_id;
    }

    public void setRoute_id(Routes route_id) {
        this.route_id = route_id;
    }

    public int getPassengers_boarded() {
        return passengers_boarded;
    }

    public void setPassengers_boarded(int passengers_boarded) {
        this.passengers_boarded = passengers_boarded;
    }

    public LocalDateTime getTrip_timestamp() {
        return trip_timestamp;
    }

    public void setTrip_timestamp(LocalDateTime trip_timestamp) {
        this.trip_timestamp = trip_timestamp;
    }

    public int getLog_id() {
        return log_id;
    }

    public void setLog_id(int log_id) {
        this.log_id = log_id;
    }
}
