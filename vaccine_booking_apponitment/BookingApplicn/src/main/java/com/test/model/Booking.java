package com.test.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name="booking_details")
@NamedQueries({ @NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b") })
public class Booking implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JoinColumn(name = "vaccine_center_id", referencedColumnName = "id")
    @ManyToOne
    private VaccineCenterTimeSlots vaccineCenterTimeSlots;
    @JoinColumn(name = "beneficiary_id", referencedColumnName = "id")
    @ManyToOne
    private Beneficiary beneficiary;
    @Column(name = "dosage_type")
    private String dosageType;
    @Column(name = "booked_date")
    private LocalDate bookedDate;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public VaccineCenterTimeSlots getVaccineCenterTimeSlots() {
	return vaccineCenterTimeSlots;
    }

    public void setVaccineCenterTimeSlots(VaccineCenterTimeSlots vaccineCenterTimeSlots) {
	this.vaccineCenterTimeSlots = vaccineCenterTimeSlots;
    }

    public Beneficiary getBeneficiary() {
	return beneficiary;
    }

    public void setBeneficiary(Beneficiary beneficiary) {
	this.beneficiary = beneficiary;
    }

    public String getDosageType() {
	return dosageType;
    }

    public void setDosageType(String dosageType) {
	this.dosageType = dosageType;
    }

    public Status getStatus() {
	return status;
    }

    public void setStatus(Status status) {
	this.status = status;
    }

    public static long getSerialVersionUID() {
	return serialVersionUID;
    }

    public LocalDate getBookedDate() {
	return bookedDate;
    }

    public void setBookedDate(LocalDate bookedDate) {
	this.bookedDate = bookedDate;
    }

    @Override public String toString() {
	return "Booking{" + "id=" + id + ", vaccineCenterTimeSlots=" + vaccineCenterTimeSlots + ", beneficiary=" + beneficiary + ", dosageType='" + dosageType + '\'' + ", status='" + status + '\'' + '}';
    }
}
