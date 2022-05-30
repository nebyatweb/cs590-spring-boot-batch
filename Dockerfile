FROM openjdk:18
RUN mkdir "/app"
ADD target/cs590-spring-boot-batch-0.0.1-SNAPSHOT.jar /app/cs590-spring-boot-batch-0.0.1-SNAPSHOT.jar
EXPOSE 3000
CMD java -jar /app/cs590-spring-boot-batch-0.0.1-SNAPSHOT.jar