package com.Adarsh.smartcampusEV.repository;

import com.Adarsh.smartcampusEV.model.Shuttlees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShuttleEV extends JpaRepository<Shuttlees,Integer> {

}
