package com.aarhankhan.juitattendanceapi.entity;


import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "Attendance")
public class Attendance {

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    private String attendanceId;

    @DynamoDBAttribute
    private String subjectId;

    @DynamoDBAutoGeneratedTimestamp
    private String timeStamp;

    @DynamoDBAttribute
    private String studentRollNo;

    @DynamoDBAttribute
    private String firstName;

    @DynamoDBAttribute
    private String lastName;

    @DynamoDBAttribute
    private String studentBatch;

}
