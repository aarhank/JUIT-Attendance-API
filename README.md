## JUIT-Attendance-API

<img alt="Java" src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white"/> <img alt="Spring boot" src="https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot"/> <img alt="Dynamodb" src="https://img.shields.io/badge/Amazon%20DynamoDB-4053D6?style=for-the-badge&logo=Amazon%20DynamoDB&logoColor=white"/>

A Spring boot application to manage attendance, database used dynamodb. 


## Required request body

**Attendance Body:**
```
{
    "subjectId":"59c4b6e0-e3ba-4e40-9834-f495b54aa528",
    "studentRollNo":"201221",
    "firstName":"Aarhan",
    "lastName":"Ali Khan",
    "studentBatch":"CS41"
}
```
**Subject Body:**
```
{
    "subjectCode":"18B17CI472",
    "subjectName":"DESIGN AND ANALYSIS OF ALGORITHMS LAB",
    "startTime":"9:00AM",
    "endTime":"11:00AM",
    "subjectSemester":"4",
    "subjectType":"Practical",
    "subjectStrength":"30",
    "subjectTeacher":"AmitKumar"
}
```

### Endpoints

* ```/v1.0/attendance```    
  Saves student attendance.
  

* ```/v1.0/allAttendance```    
  Fetch all the attendance details from the database.
  

* ```/v1.0/attendance/{id}```   
  Fetch the attendance details by subjectId.
  

* ```/v1.0/attendanceByRoll/{rollNo}```   
  Fetch the attendance details by roll number.
  

* ```/v1.0/subject```    
  Saves the subject, returns SubjectId.
  

* ```/v1.0/subject```    
  Fetch all the subjects.
  

* ```/v1.0/subjectByTeacher/{teacherName}```   
  Fetch the subjects by teacher name.
  

## Examples

- ### Subjects By Teacher Name
 
**Endpoint:**      
```/v1.0/subject/AmitKumar```      
     
**Response:**
  ```
 [
    {
        "subjectId": "dab855b9-0cf0-4d21-83d3-ee215c7e5683",
        "timeStamp": "2022-06-17T16:18:15.736Z",
        "subjectCode": "18B11CI412",
        "subjectName": "DESIGN AND ANALYSIS OF ALGORITHMS",
        "startTime": "2:00PM",
        "endTime": "3:00PM",
        "subjectSemester": "4",
        "subjectType": "Lecture",
        "subjectStrength": "50",
        "subjectTeacher": "AmitKumar"
    },
    {
        "subjectId": "59c4b6e0-e3ba-4e40-9834-f495b54aa528",
        "timeStamp": "2022-06-17T16:16:47.863Z",
        "subjectCode": "18B17CI472",
        "subjectName": "DESIGN AND ANALYSIS OF ALGORITHMS LAB",
        "startTime": "9:00AM",
        "endTime": "11:00AM",
        "subjectSemester": "4",
        "subjectType": "Practical",
        "subjectStrength": "30",
        "subjectTeacher": "AmitKumar"
    }
]
  ```
- ### Attendance By Roll number

**Endpoint:**      
```/v1.0/AttendanceByRoll/201221```  
    
**Response:**       
  ```
  [
    {
        "attendanceId": "093de7b4-2ac6-41bb-8e50-e9bcd35cb5fe",
        "subjectId": "59c4b6e0-e3ba-4e40-9834-f495b54aa528",
        "timeStamp": "2022-06-17T16:28:33.649Z",
        "studentRollNo": "201221",
        "firstName": "Aarhan",
        "lastName": "Ali Khan",
        "studentBatch": "CS41"
    }
]
  ```
