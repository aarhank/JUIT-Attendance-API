package com.aarhankhan.juitattendanceapi.controller;

import com.aarhankhan.juitattendanceapi.entity.Attendance;
import com.aarhankhan.juitattendanceapi.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AttendanceController {
    @Autowired
    private AttendanceRepository attendanceRepository;

    @PostMapping("/v1.0/attendance")
    public String setAttendance(@RequestBody Attendance attendance){
        return attendanceRepository.saveAttendance(attendance);
    }

    @GetMapping("/v1.0/attendance/{id}")
    public Attendance getAttendance(@PathVariable("id") String attendanceId){
        return attendanceRepository.getAttendanceById(attendanceId);
    }

    @DeleteMapping("/v1.0/attendance/{id}")
    public String deleteAttendance(@PathVariable("id") String attendanceId){
        attendanceRepository.deleteAttendanceById(attendanceId);
        return "Attendance record deleted";
    }

    @GetMapping("/v1.0/allAttendance")
    public List<Attendance> getAllAttendance(){
        return attendanceRepository.findAll();
    }

}
