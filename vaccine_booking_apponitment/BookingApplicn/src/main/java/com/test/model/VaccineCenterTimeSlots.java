package com.test.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name="vaccine_center_timeslots")
@NamedQueries({ @NamedQuery(name = "VaccineCenterTimeSlots.findAll", query = "SELECT vc FROM VaccineCenterTimeSlots vc") })
public class VaccineCenterTimeSlots implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "vaccine_center_id", referencedColumnName = "id")
    @ManyToOne
    private VaccineCenter vaccineCenter;
    @Column(name = "from_time")
    private LocalTime fromTime;
    @Column(name = "to_time")
    private LocalTime toTime;
    @Column(name = "first_dose")
    private Integer firstDose;
    @Column(name = "second_dose")
    private Integer secondDose;
    @Column(name = "users_count")
    private Integer usersCount;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "modified_by")
    private String modifiedBy;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    public Integer getId() {
	return id;
    }

    public VaccineCenter getVaccineCenter() {
	return vaccineCenter;
    }

    public LocalTime getFromTime() {
	return fromTime;
    }

    public LocalTime getToTime() {
	return toTime;
    }

    public Integer getFirstDose() {
	return firstDose;
    }

    public Integer getSecondDose() {
	return secondDose;
    }

    public Integer getUsersCount() {
	return usersCount;
    }

    public Status getStatus() {
	return status;
    }

    public String getCreatedBy() {
	return createdBy;
    }

    public String getModifiedBy() {
	return modifiedBy;
    }

    public Date getCreatedDate() {
	return createdDate;
    }

    public Date getModifiedDate() {
	return modifiedDate;
    }

    @Override public String toString() {
	return "VaccineCenterTimeSlots{" + "id=" + id + ", vaccineCenter=" + vaccineCenter + ", fromTime=" + fromTime + ", toTime=" + toTime + ", firstDose=" + firstDose + ", secondDose=" + secondDose + ", usersCount=" + usersCount + ", status='" + status + '\'' + ", createdBy='" + createdBy + '\'' + ", modifiedBy='" + modifiedBy + '\'' + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + '}';
    }
}
