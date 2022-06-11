package com.aarhankhan.juitattendanceapi.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBDocument
public class Subject {

    @DynamoDBAttribute
    private String subjectCode;

    @DynamoDBAttribute
    private String subjectName;

    @DynamoDBAttribute
    private String subjectType;

    @DynamoDBAttribute
    private String subjectStrength;

    @DynamoDBAttribute
    private String subjectTeacher;

}
