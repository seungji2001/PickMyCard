# Use OpenJDK 21 as the base image
FROM openjdk:21

# Set the working directory in the container
WORKDIR /app

# Copy Gradle files
COPY . .

# Expose the port the app runs on
EXPOSE 8015

# Set environment variables
ENV SERVER_PORT=8015
ENV EUREKA_CLIENT_SERVICEURL_DEFAULTZONE=http://pickmycardserver:8761/eureka

ENTRYPOINT ["java", "-jar", "./build/libs/PickMyCardClient-card-0.0.1-SNAPSHOT.jar"]
