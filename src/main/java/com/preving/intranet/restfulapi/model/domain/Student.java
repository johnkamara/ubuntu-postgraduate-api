package com.preving.intranet.restfulapi.model.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "SAJP", name = "STUDENTS")
public class Student implements Serializable {

    private int id;

    @Id
    @Column(name = "ID", nullable = false)
    @SequenceGenerator(name = "STUDENTS_SEQ", sequenceName = "STUDENTS_SEQ", schema = "SAJP", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUDENTS_SEQ")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

}
