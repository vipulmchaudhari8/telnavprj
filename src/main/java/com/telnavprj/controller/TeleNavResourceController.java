package com.telnavprj.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.telnavprj.model.Device;
import com.telnavprj.service.DeviceDAOImpl;

@RestController
@CrossOrigin()
public class TeleNavResourceController {

	@Autowired
	private DeviceDAOImpl deviceDAOImpl;
	
	@RequestMapping(path= "/echo", method=RequestMethod.POST )	
	@PostMapping(value = "/echo",  consumes = {MediaType.APPLICATION_JSON_VALUE},
				 produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Device> echo(@Valid @RequestBody Device device)   {
		 device.setCreatedDate(new Date());
		 device.setLastModifiedDate(new Date());
		 deviceDAOImpl.saveDevice(device);
		 return new ResponseEntity<Device>(device, HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value= "/device", method=RequestMethod.POST )	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
				 produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> getDevice(@RequestBody Device device) {
		deviceDAOImpl.saveDevice(device);
		 device.setCreatedDate(new Date());
		 device.setLastModifiedDate(new Date());		
		 
		 return new ResponseEntity(device.getDeviceId(), HttpStatus.OK);
	}
	
	@RequestMapping({ "/nocontent" })
	@ResponseStatus( HttpStatus.NO_CONTENT)
	public void nocontent() {}
	
	@RequestMapping({ "/h2-console" })
	@ResponseStatus( HttpStatus.NO_CONTENT)
	public void nocontent1() {}
	
	@RequestMapping(value="*")
	@ResponseStatus( HttpStatus.BAD_REQUEST)
	public void badRequest() {}	
}
