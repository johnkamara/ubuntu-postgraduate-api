package com.preving.intranet.restfulapi.web;

import com.preving.intranet.restfulapi.model.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/students")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentsController {

    @Autowired
    public StudentsService studentsService;

}
