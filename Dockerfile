# https://spring.io/guides/gs/spring-boot-docker
# https://stackoverflow.com/questions/46057625/externalising-spring-boot-properties-when-deploying-to-docker

FROM openjdk:17-jdk-alpine
COPY build/libs/*SNAPSHOT.jar app.jar

# NOTE: The application.properties just contains generic configurations true for all envs.
# Any env specific configurations should be passed as env variables to the docker run command.
COPY src/main/resources/application.properties application.properties
ENTRYPOINT ["java","-jar","/app.jar"]