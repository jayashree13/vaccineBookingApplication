package com.test.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="vaccine_center")
@NamedQueries({ @NamedQuery(name = "VaccineCenter.findAll", query = "SELECT vc FROM VaccineCenter vc") })
public class VaccineCenter implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    public Integer getId() {
	return id;
    }

    public String getName() {
	return name;
    }

    public Status getStatus() {
        return status;
    }

    @Override public String toString() {
	return "VaccineCenter{" + "id=" + id + ", name='" + name + '\'' + ", status='" + status + '\'' + '}';
    }
}
