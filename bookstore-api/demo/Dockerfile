FROM openjdk:17 AS build

COPY pom.xml mvnw ./
RUN chmod -x mvnw
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package

FROM openjdk:17
WORKDIR /bookstore-api/demo
COPY --from=build target/*.jar bookstore.jar
ENTRYPOINT ["java", "-jar", "bookstore.jar"]
