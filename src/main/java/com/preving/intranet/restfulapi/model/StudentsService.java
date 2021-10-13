package com.preving.intranet.restfulapi.model;

import com.preving.intranet.restfulapi.model.domain.Student;

import java.util.List;

public interface StudentsService {
    List<Student> getAllStudents();

    Student getStudentById(Integer studentId);

    Student updateStudent(Student student);
//    Student deleteStudent(Integer studentId) throws Exception;
}
