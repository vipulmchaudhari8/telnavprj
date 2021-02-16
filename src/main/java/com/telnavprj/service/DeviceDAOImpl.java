package com.telnavprj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.telnavprj.dao.DeviceDAO;
import com.telnavprj.model.Device;

@Service
public class DeviceDAOImpl implements DeviceService {

	@Autowired
	DeviceDAO deviceDAO;


	public ResponseEntity<?> saveDevice(Device device) {
		
		try {
			deviceDAO.save(device);
		} catch(Exception e ) {
			 return new ResponseEntity<Device>( HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<Device>( HttpStatus.OK);
	}

}
