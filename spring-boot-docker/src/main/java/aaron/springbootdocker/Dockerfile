FROM openjdk:8u181-jdk-alpine
ARG workdir=/app
VOLUME ${workdir}
WORKDIR ${workdir}
ADD spring-boot-docker-0.0.1-SNAPSHOT.jar spring-boot-docker.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","spring-boot-docker.jar"]