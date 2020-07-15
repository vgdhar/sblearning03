FROM openjdk:8
ADD target/sblearning03-0.0.1-SNAPSHOT.jar sblearning03-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "sblearning03-0.0.1-SNAPSHOT.jar"]
