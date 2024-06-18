# Use a base image with OpenJDK
FROM openjdk:22

# Copy the JAR file into the container
COPY target/library-0.0.1-SNAPSHOT.jar library-0.0.1-SNAPSHOT.jar

# Expose the port that the app will run on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "library-0.0.1-SNAPSHOT.jar"]
