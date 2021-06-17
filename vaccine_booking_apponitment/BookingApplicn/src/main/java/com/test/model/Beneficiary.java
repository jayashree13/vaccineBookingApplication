package com.test.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name="beneficiary")
@NamedQueries({ @NamedQuery(name = "Beneficiary.findAll", query = "SELECT b FROM Beneficiary b") })
public class Beneficiary implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "aadhar_no")
    private String aadharNo;
    @Column(name = "phone_no")
    private String phoneNo;

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public LocalDate getDateOfBirth() {
	return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
    }

    public String getAadharNo() {
	return aadharNo;
    }

    public void setAadharNo(String aadharNo) {
	this.aadharNo = aadharNo;
    }

    public String getPhoneNo() {
	return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
	this.phoneNo = phoneNo;
    }

    @Override public String toString() {
	return "Beneficiary{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", dateOfBirth=" + dateOfBirth + ", aadharNo='" + aadharNo + '\'' + ", phoneNo='" + phoneNo + '\'' + '}';
    }
}
