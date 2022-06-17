package com.aarhankhan.juitattendanceapi.controller;

import com.aarhankhan.juitattendanceapi.entity.Subject;
import com.aarhankhan.juitattendanceapi.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubjectController {

    @Autowired
    private SubjectRepository subjectRepository;

    @PostMapping("/v1.0/subject")
    public String setSubject(@RequestBody Subject subject){
        return subjectRepository.saveSubject(subject);
    }

    @GetMapping("/v1.0/subject")
    public List<Subject> getSubject(){
        return subjectRepository.getSubject();
    }

    @GetMapping("/v1.0/subjectByTeacher/{teacher}")
    public List<Subject> getSubjectByTeacher(@PathVariable("teacher") String teacher){
        return subjectRepository.getSubjectByTeacher(teacher);
    }
}
