package com.preving.intranet.restfulapi.model.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "sajp", name = "students")
public class Student implements Serializable {
    @Id
    @Column(name = "ID", nullable = false)
    @SequenceGenerator(name = "STUDENTS_SEQ", sequenceName = "STUDENTS_SEQ", schema = "SAJP", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUDENTS_SEQ")
    private int ID;
    @Column(length = 45)
    private String NAME;
    @Column(length = 25)
    private String BIRTHDAY;
    @Column(length = 25)
    private String LOCALITY;
    @Column(length = 25, nullable = false, unique = true)
    private String YEAR;
    @Column(length = 25, nullable = false)
    private String ACTIVE;

    public Student(int ID, String NAME, String BIRTHDAY, String LOCALITY, String YEAR, String ACTIVE) {
        this.ID = ID;
        this.NAME = NAME;
        this.BIRTHDAY = BIRTHDAY;
        this.LOCALITY = LOCALITY;
        this.YEAR = YEAR;
        this.ACTIVE = ACTIVE;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getBIRTHDAY() {
        return BIRTHDAY;
    }

    public void setBIRTHDAY(String BIRTHDAY) {
        this.BIRTHDAY = BIRTHDAY;
    }

    public String getLOCALITY() {
        return LOCALITY;
    }

    public void setLOCALITY(String LOCALITY) {
        this.LOCALITY = LOCALITY;
    }

    public String getYEAR() {
        return YEAR;
    }

    public void setYEAR(String YEAR) {
        this.YEAR = YEAR;
    }

    public String getACTIVE() {
        return ACTIVE;
    }

    public void setACTIVE(String ACTIVE) {
        this.ACTIVE = ACTIVE;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", NAME='" + NAME + '\'' +
                ", BIRTHDAY='" + BIRTHDAY + '\'' +
                ", LOCALITY='" + LOCALITY + '\'' +
                ", YEAR='" + YEAR + '\'' +
                ", ACTIVE='" + ACTIVE + '\'' +
                '}';
    }
}
