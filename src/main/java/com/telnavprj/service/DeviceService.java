package com.telnavprj.service;

import org.springframework.http.ResponseEntity;

import com.telnavprj.model.Device;

public interface DeviceService {
	ResponseEntity<?> saveDevice(Device device);
}
