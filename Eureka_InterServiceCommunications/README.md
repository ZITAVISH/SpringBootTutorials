# SpringBootTutorials

This consists of a Eureka Server (Micro Service), A domain Microservice (Microservice 1) and a CRUD Microservice (Microservice 2)

Worklog : - 
1. Building a Eureka Service Discovery Microservice
2. Building 2 other microservice and registering them with eureka for inter service data exchange


Steps : -

1. Create a Eureka Server and host it.
2. Create Microservice 1 , register it with eureka (follow the application.yml for registration configs) and host it in another port.
3. Create Microservice 2 , register it with eureka (follow the application.yml for registration configs) and host it in another port.
4. Fetch the host+port i.e. the route/ domain url of Microservice 2 to connect from Microservice 1.
5. Connect Microservice 2 from Microservice 1 using RestTemplate methods like exchange , postForObject , postForEntity , etc.


References : -
https://www.tutorialspoint.com/spring_boot/index.htm