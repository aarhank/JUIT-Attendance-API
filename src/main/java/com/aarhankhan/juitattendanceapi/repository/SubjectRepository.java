package com.aarhankhan.juitattendanceapi.repository;


import com.aarhankhan.juitattendanceapi.entity.Attendance;
import com.aarhankhan.juitattendanceapi.entity.Subject;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SubjectRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public String saveSubject(Subject subject) {
        dynamoDBMapper.save(subject);
        return subject.getSubjectId();
    }

    public List<Subject> getSubject() {
        return dynamoDBMapper.scan(Subject.class, new DynamoDBScanExpression());
    }

    public List<Subject> getSubjectByTeacher(String teacher) {
        Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
        eav.put(":val1", new AttributeValue().withS(teacher));

        DynamoDBScanExpression expression = new DynamoDBScanExpression();
        expression.withFilterExpression("subjectTeacher = :val1").withExpressionAttributeValues(eav);

        return dynamoDBMapper.scan(Subject.class, expression);
    }
}
