FROM maven:3.9-eclipse-temurin-22-jammy AS build
COPY ..
RUN mvn clean package -DskipTests

FROM openjdk:22-rc-jdk-oracle
COPY --from=build /target/demo-platzi-1.0.0.jar build.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "\"-Dspring.profiles.active=prod\"" "build.jar"]