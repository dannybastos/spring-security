# Spring-security-sample-app

This project has 3 branches:

- oauth2 and master
- http-basic


## System requirements
- docker
- docker-compose

## How to run
```
docker-compose up
```

## How to test

Get access token from :
```
curl -v \
-H 'authorization: Basic YXBwOnNlY3JldC1hcHA=' \
-H 'content-type: application/x-www-form-urlencoded' \
-d 'grant_type=password&username=user&password=secret' \
-X POST localhost:8080/oauth/token
```

>{"access_token": **token**"token_type":"bearer","refresh_token":"a7dff64d-
6f92-4d80-92b3-5c905c212791","expires_in":43199,"scope":"password"}


Apply the token like this :

>curl -v -H'authorization:Bearer **token**' localhost:8080/
