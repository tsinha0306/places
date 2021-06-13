# places
proximity server

Creating Users:
1. mvn -f .\projects\pom.xml install
2. curl.exe --header 'Content-Type: application/json' --data '{\"id\":\"abc\",\"username\":\"tanyasinha\",\"firstName\":\"tanya\",\"lastName\":\"sinha\",\"password\":\"abcdgj\"}' --request POST http://localhost:8082/users/register

Creating Place:
1. mvn -f .\projects\pom.xml install
2. curl.exe --header 'Content-Type: application/json' --data '{\"id\":\"abc\",\"name\":\"RedBowls\",\"latitude\":120,\"longitude\":30,\"country\":\"USA\"}' --request POST http://localhost:8081/api_gateway/create_place

Creating Review:
1. mvn -f .\projects\pom.xml install
2. curl.exe --header 'Content-Type: application/json' --data '{\"id\":\"abc\",\"place_id\":\"redbw\",\"description\":\"itsagreatplacevalueformoney\"}' --request POST http://localhost:8081/api_gateway/create_review


