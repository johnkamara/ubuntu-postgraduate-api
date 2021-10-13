package com.preving.intranet.restfulapi.model.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(schema = "SAJP", name = "STUDENTS")
public class Student implements Serializable {

    private int id;
    //columns with constraints
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;
    @NotNull
    @Column(name = "birthday", nullable = false)
    private Date birthday;
    @NotNull
    @Column(name = "locality", nullable = false)
    private String locality;
    @NotNull

    @Column(name = "university", nullable = false)
    private String university;
    @NotNull
    @Column(name = "postgraduate_year", nullable = false)
    private int postgraduate_year;
    @NotNull
    @Column(name = "active", nullable = false)
    private int active;

    //super constructor
    public Student() {
    }

    public Student(String name, Date birthday, String locality, String university, int postgraduate_year, int active) {
        this.name = name;
        this.birthday = birthday;
        this.locality = locality;
        this.university = university;
        this.postgraduate_year = postgraduate_year;
        this.active = active;
    }

    @Id
    @Column(name = "ID", nullable = false)
    @SequenceGenerator(name = "STUDENTS_SEQ", sequenceName = "STUDENTS_SEQ", schema = "SAJP", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUDENTS_SEQ")
    public int getId() {
        return id;
    }

    //constructors

    public void setId(int id) {
        this.id = id;
    }

    //getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public int getPostgraduate_year() {
        return postgraduate_year;
    }

    public void setPostgraduate_year(int postgraduate_year) {
        this.postgraduate_year = postgraduate_year;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
