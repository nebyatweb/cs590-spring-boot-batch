FROM maven:openjdk
ADD target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]