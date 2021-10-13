package com.preving.intranet.restfulapi.model.dao;

import com.preving.intranet.restfulapi.model.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepository extends JpaRepository<Student, Integer> {
    Object findById(Integer studentId);

//    void deleteById(Integer studentId);
}
