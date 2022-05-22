FROM openjdk:17 AS build

COPY pom.xml mvnw ./
RUN chmod -x mvnw
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package

FROM openjdk:17
WORKDIR /e-shop-api/demo
COPY --from=build target/*.jar e-shop.jar
ENTRYPOINT ["java", "-jar", "e-shop.jar"]
