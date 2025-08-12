## cURL for Testing

#### Direct Exchange cURL

curl -X POST "http://localhost:8080/api/send/direct/practice.key1" \
-H "Content-Type: text/plain" \
-d "Hello Direct practice.Key1"

curl -X POST "http://localhost:8080/api/send/direct/practice.key2" \
-H "Content-Type: text/plain" \
-d "Hello Direct practice.Key2"

#### Fanout Exchange cURL

curl -X POST "http://localhost:8080/api/send/fanout" \
-H "Content-Type: application/json" \
-d '"Hello Fanout"'

#### Topic Exchange cURL

curl -X POST "http://localhost:8080/api/send/topic/sports.football.bat" \
-H "Content-Type: application/json" \
-d "\"Hello Sports Football Bat\""

curl -X POST "http://localhost:8080/api/send/topic/sports.football" \
-H "Content-Type: application/json" \
-d "\"Hello Sports Football\""

#### Header Exchange cURL

curl -X POST http://localhost:8080/api/send/header/1 \
-H "Content-Type: application/json" \
-d "\"Hello PDF Report\""

curl -X POST http://localhost:8080/api/send/header/2 \
-H "Content-Type: application/json" \
-d "\"Hello PDF Report\""


