# -------- 🏗️ Stage 1: Build the app using Maven --------
FROM maven:3.9.6-eclipse-temurin-17 AS builder

# Make directory for the app
WORKDIR /app

# Copy pom.xml and all source files
COPY . .

# Build the app and skip tests for faster build
RUN mvn clean package -DskipTests


# -------- 🚀 Stage 2: Run the built JAR --------
FROM openjdk:17-jdk-slim

# Working directory inside runtime container
WORKDIR /app

# Copy the built jar from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose Spring Boot default port
EXPOSE 8080

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
