package com.telnavprj.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.telnavprj.audit.Auditable;

@Entity
@Table(name="Device")
@EntityListeners(AuditingEntityListener.class)
public class Device extends Auditable {

    @Id
    @JsonProperty("DeviceId") 
    @NotBlank(message = "DeviceId is mandatory")
    public String deviceId;
    
    @JsonProperty("RecordType") 
    @NotBlank(message = "RecordType is mandatory")
    public String recordType;
        
    @JsonProperty("EventDateTime") 
    public Date eventDateTime;

    @JsonProperty( "FieldA") 
    @Min(value = 1)
    public int fieldA;
    
    @JsonProperty("FieldB") 
    @NotBlank(message = "FieldB is mandatory")
    public String fieldB;
    
    @JsonProperty("FieldC") 
    @Min(value = 0)
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
