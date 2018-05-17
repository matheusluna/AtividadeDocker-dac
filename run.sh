mvn clean packege
docker build -t atividade/app .
docker run -p 8081:8080 -d --name app atividade/app
