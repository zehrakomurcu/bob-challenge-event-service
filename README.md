# Project Description

This project is implemented for **Takeaway** as an assignment project. It's a Spring Boot project which developed by using Java language.

## Build & Run

This project uses Mysql as database server and Kafka as messaging queue. You can follow the next instructions to run the application.

### Docker containers

You can easily run needed servers as dockerised containers at root directory. Please run the following command:


```bash
docker-compose up
```

By completing this step, you will have a running mysql server at `localhost:3306`

### Run Application

This project uses Maven as build tool. You can run the following commands to build and run the application:

```bash
mvn clean package spring-boot:repackage
java -jar target/eventService-0.0.1-SNAPSHOT.jar
```

### Run Application as Docker Container

In the root directory you can find the Dockerfile to dockerize the application. 

Go to root project and run following commands:

```
docker build -t event-service . 
docker run --rm -p 9090:9090 event-service
```


## REST APIs

### Get Employee Events by ID

Gets all events for employee in an ascending order. 
* Each event represents messages consumed from kafka and stored in database.
* Each event has the metadata which includes original source id, creation date and event type.
* Each event has data payload which determines the last state of original source.

URL path: ```GET events/employees/{id}```


Response Model: 
```json
[
       {
            "id": "21e563f7-5476-42ed-970d-a79a82d3fd58",
            "eventType": "EMPLOYEE_CREATED",
            "sourceId": "90f0cc5d-d8b5-47a6-be74-0d9fd62a8e49",
            "createdAt": "2020-08-22T09:05:23Z",
            "payload": {
                "name": "Zehrut",
                "birthday": "1993-07-02T22:00:00.000+0000",
                "email": "zerut@test.com",
                "departmentName": "Engineering"
            }
        },
        {
            "id": "60173c13-1367-4efd-bd17-7dbce97143f5",
            "eventType": "EMPLOYEE_UPDATED",
            "sourceId": "90f0cc5d-d8b5-47a6-be74-0d9fd62a8e49",
            "createdAt": "2020-08-22T09:06:03Z",
            "payload": {
                "name": "Zerut Komurcu",
                "birthday": "1993-07-02T22:00:00.000+0000",
                "email": "zerut@test.com",
                "departmentName": "Engineering"
            }
        },
        {
            "id": "45c2842a-c237-41d1-af96-06f4bebd3392",
            "eventType": "EMPLOYEE_DELETED",
            "sourceId": "90f0cc5d-d8b5-47a6-be74-0d9fd62a8e49",
            "createdAt": "2020-08-22T09:06:39Z",
            "payload": {
                "name": "Zerut Komurcu",
                "birthday": "1992-06-25T22:00:00.000+0000",
                "email": "zerut@test.com",
                "departmentName": "Engineering"
            }
        }
]
```

## Postman Collections

You can find the postman collection for each REST API call in project's root directory. 

The file name:
```
event-service.postman_collection.json
```

## Author

Zehra Nur Komurcu
