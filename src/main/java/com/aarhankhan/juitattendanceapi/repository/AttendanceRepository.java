package com.aarhankhan.juitattendanceapi.repository;

import com.aarhankhan.juitattendanceapi.entity.Attendance;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AttendanceRepository {
    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public String saveAttendance(Attendance attendance) {
        dynamoDBMapper.save(attendance);
        return "Attendance Uploaded";
    }


    public List<Attendance> getAttendanceById(String attendanceId) {
        Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
        eav.put(":val1", new AttributeValue().withS(attendanceId));

        DynamoDBScanExpression expression = new DynamoDBScanExpression();
        expression.withFilterExpression("subjectId = :val1").withExpressionAttributeValues(eav);

        return dynamoDBMapper.scan(Attendance.class, expression);
    }


    public void deleteAttendanceById(String attendanceId) {
        dynamoDBMapper.delete(attendanceId);
    }


    public List<Attendance> findAll() {
        return dynamoDBMapper.scan(Attendance.class, new DynamoDBScanExpression());
    }

    public List<Attendance> getAttendanceByRoll(String rollNo) {
        Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
        eav.put(":val1", new AttributeValue().withS(rollNo));

        DynamoDBScanExpression expression = new DynamoDBScanExpression();
        expression.withFilterExpression("studentRollNo = :val1").withExpressionAttributeValues(eav);

        return dynamoDBMapper.scan(Attendance.class, expression);
    }
}
