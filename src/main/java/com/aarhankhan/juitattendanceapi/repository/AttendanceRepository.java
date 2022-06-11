package com.aarhankhan.juitattendanceapi.repository;

import com.aarhankhan.juitattendanceapi.entity.Attendance;
import com.aarhankhan.juitattendanceapi.entity.Student;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AttendanceRepository {
    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public String saveAttendance(Attendance attendance) {
        dynamoDBMapper.save(attendance);
        return "Attendance Uploaded";
    }


    public Attendance getAttendanceById(String attendanceId) {
        return dynamoDBMapper.load(Attendance.class,attendanceId);
    }


    public void deleteAttendanceById(String attendanceId) {
        dynamoDBMapper.delete(attendanceId);
    }


    public List<Attendance> findAll() {
        return dynamoDBMapper.scan(Attendance.class, new DynamoDBScanExpression());
    }
}
