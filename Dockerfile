FROM openjdk:18-alpine
	
WORKDIR /app

COPY . .

RUN chmod +x mvnw && ./mvnw package

ENTRYPOINT java -jar /app/target/AlbumList-0.0.1-SNAPSHOT.jar
