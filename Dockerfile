# 🐧 Step 1: Use a base image with Java
FROM openjdk:17-jdk-slim

# 📂 Step 2: Create working directory inside the container
WORKDIR /app

# 📦 Step 3: Copy the built jar file into the container
COPY target/To-Do-0.0.1-SNAPSHOT.jar app.jar

# 🚪 Step 4: Expose the Spring Boot default port
EXPOSE 8080

# ▶️ Step 5: Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
