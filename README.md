# spring-security

## How to run

## How to test

get accessToken from : 

curl -v \
-H 'authorization: Basic YXBwOnNlY3JldC1hcHA=' \
-H 'content-type: application/x-www-form-urlencoded' \
-d 'grant_type=password&username=user&password=secret' \
-X POST localhost:8080/oauth/token


curl -v -H'authorization:Bearer <token>' localhost:8080/