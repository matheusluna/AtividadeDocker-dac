docker build -t atividade/banco ./postgres
docker run -p 5433:5432 -d --name banco atividade/banco

mvn clean packege
docker build -t atividade/app .
docker run -p 8081:8080 -d --name app --link banco:host-banco atividade/app
