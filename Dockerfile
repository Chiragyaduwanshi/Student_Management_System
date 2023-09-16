# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the compiled Spring Boot application JAR file into the container
COPY target/spring-boot-docker.jar app.jar

# Expose the port that your Spring Boot application listens on
EXPOSE 8080

# Define environment variables (if needed)
# ENV SPRING_PROFILES_ACTIVE=production

# Command to run your application
CMD ["java", "-cp", "app.jar", "com.demo.Springdemoproject.SpringDemoProjectApplication"]
