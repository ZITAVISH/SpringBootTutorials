This is a sample microservice . Let the name be domain

Features : 
1. It does inter service data calls using  eureka service discovery
2. It handles different http status codes based on the specific scenario .


How to connect to another Microservice ?
 To connect to another microservice we need the route or the domain url of the microservice followed the specific api endpoint

 For eg : -

 Domain url of a microservice : http://localhost:8000 (Unknown to us . Can be retrieved from Eureka)
 api endpoint: /sampleApiEndpoint (Known to Us)

Whole url = http://localhost:8000/sampleApiEndpoint

To get the whole url we first need the domain url [(host+port) -> where it is hosted] which can be retrieved from Eureka via Discovery Client .

Once we retrieve the domain url we can concatenate the api endpoint and hit the specific api of another microservice using RestTemplate methods like exchange , postForEntity , postForObject etc.