package com.telnavprj.test;

import static org.junit.Assert.assertEquals;

import java.util.Collections;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.telnavprj.model.Device;

@RunWith(SpringRunner.class)
public class TeleNavResourceIT {

	private int port = 8080;

	TestRestTemplate restTemplate = new TestRestTemplate();
	String actual = "/device";

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testGetDevice() throws Exception {
		int actualStatusCode =401;
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setBearerAuth(
				"Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZWxlbmF2IiwiZXhwIjoxNjEzODg3NzkyLCJpYXQiOjE2MTM4Njk3OTJ9.4rIBFEgOMIt6vf1XkM5wpy1c8D5CQ5DunAAdhqyKy7Yaz92_QINdETczaXhv_PxjHn-octxRwk--Y9cHfYbScQ");

		// set `content-type` header
		headers.setContentType(MediaType.APPLICATION_JSON);
		// set `accept` header
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		Device device = new Device();
		device.setDeviceId("357370040159771");
		device.setRecordType("xxx");
		device.setFieldA(68);
		device.setFieldB("xxx");
		device.setFieldC(123.45);

		JSONObject personJsonObject = new JSONObject();
		personJsonObject.put("device", device);
		HttpEntity<String> request = new HttpEntity<String>(personJsonObject.toString(), headers);

		ResponseEntity<String> responseEntity = this.restTemplate.postForEntity("http://localhost:8080/device", request,
				String.class);

		assertEquals(actualStatusCode, responseEntity.getStatusCodeValue());
	}

	@Test
	public void testGetDeviceLocation() throws Exception {
		String actual = null;
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setBearerAuth(
				"Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZWxlbmF2IiwiZXhwIjoxNjEzODgwNDI1LCJpYXQiOjE2MTM4NjI0MjV9.Z8NKRh6RLMLItHs6x5mn96176lEG-imwIGa6Vd_MzEwA9JtNywqGCRaxcL2JUO0JLtqsjlAATmozjlVhAr0hSQ");

		// set `content-type` header
		headers.setContentType(MediaType.APPLICATION_JSON);
		// set `accept` header
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		Device device = new Device();
		device.setDeviceId("357370040159771");
		device.setRecordType("xxx");
		device.setFieldA(68);
		device.setFieldB("xxx");
		device.setFieldC(123.45);
		
		HttpEntity<Device> entity = new HttpEntity<Device>(device, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/device"),
				HttpMethod.POST, entity, String.class);

		assertEquals(actual, response.getHeaders().get(HttpHeaders.LOCATION));
	}
	
	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
}
