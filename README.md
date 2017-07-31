# Demo of Spring Boot and micro services

It consists of:

1. employee-service: provides CRUD operations for employee entity
2. analytics-service: consumes previous service and calculate some metrics
3. eureka-service: allows interactions between services

Run these apps in order:
1. EurekaServiceApplication.java 
2. EmployeeServiceApplication.java
3. AnalyticsServiceApplication.java

Result:
http://localhost:1111/  - eureka console
http://localhost:2222/  - employee-service
http://localhost:3333/  - analytics-service

Employee service has some demo data. So just GET http://localhost:3333/employee-metrics 