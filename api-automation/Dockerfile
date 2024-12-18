# Use Maven image with JDK 17
FROM maven:3.8.8-eclipse-temurin-17

# Set working directory
WORKDIR /usr/src/app

# Copy the project files into the container
COPY . .

# Build the project
RUN mvn clean install

# Run tests
CMD ["mvn", "test"]