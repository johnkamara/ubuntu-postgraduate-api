package com.preving.intranet.restfulapi.model;

import com.preving.intranet.restfulapi.model.dao.StudentsRepository;
import com.preving.intranet.restfulapi.model.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsManager implements StudentsService {

    private StudentsRepository studentsRepository;


    @Autowired
    public StudentsManager(StudentsRepository studentsRepository) {
        super();
        this.studentsRepository = studentsRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentsRepository.findAll();
    }


    @Override
    public Student getStudentById(Integer studentId) {
        return (Student) studentsRepository.findById(studentId);
    }


    @Override
    public Student updateStudent(Student student) {
        return studentsRepository.save(student);
    }


//    @Override
//    public Student deleteStudent(Integer studentId) throws Exception {
//        Student deletedStudent = null;
//try {
//    deletedStudent=studentsRepository.findById(studentId).orElse(null);
//    if (deletedStudent==null){
//        throw new Exception("Student not available");
//    }else {
//        studentsRepository.deleteById(studentId);
//    }
//}
//catch (Exception ex){
//    throw ex;
//}
//return deletedStudent;
//    }
}
