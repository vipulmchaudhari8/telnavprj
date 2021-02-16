package com.telnavprj.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.telnavprj.model.Device;

@Repository
public interface DeviceDAO extends CrudRepository<Device, Integer> {

}
