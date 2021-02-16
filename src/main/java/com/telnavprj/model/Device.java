package com.telnavprj.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.telnavprj.audit.Auditable;

@Entity
@Table(name="Device")
@EntityListeners(AuditingEntityListener.class)
public class Device extends Auditable {

    @JsonProperty("RecordType") 
    @NotBlank(message = "RecordType is mandatory")
    @Id
    public String recordType;
    
    @JsonProperty("DeviceId") 
    @NotBlank(message = "DeviceId is mandatory")
    public String deviceId;
    
    @JsonProperty("EventDateTime") 
    //@NotBlank(message = "EventDateTime is mandatory")
    public Date eventDateTime;

    @JsonProperty("FieldA") 
    //@NotBlank(message = "FieldA is mandatory")
    public int fieldA;
    
    @JsonProperty("FieldB") 
    //@NotBlank(message = "FieldB is mandatory")
    public String fieldB;
    
    @JsonProperty("FieldC") 
    //@NotBlank(message = "FieldC is mandatory")
    public double fieldC;

	public String getRecordType() {
		return recordType;
	}


	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}


	public String getDeviceId() {
		return deviceId;
	}


	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}


	public Date getEventDateTime() {
		return eventDateTime;
	}


	public void setEventDateTime(Date eventDateTime) {
		this.eventDateTime = eventDateTime;
	}


	public int getFieldA() {
		return fieldA;
	}


	public void setFieldA(int fieldA) {
		this.fieldA = fieldA;
	}


	public String getFieldB() {
		return fieldB;
	}


	public void setFieldB(String fieldB) {
		this.fieldB = fieldB;
	}


	public double getFieldC() {
		return fieldC;
	}


	public void setFieldC(double fieldC) {
		this.fieldC = fieldC;
	}
	

	
}
