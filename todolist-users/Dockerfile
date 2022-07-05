FROM openjdk:17-jdk-alpine as builder

WORKDIR /app/todolist-users

COPY ./pom.xml /app
COPY ./todolist-users/.mvn ./.mvn
COPY ./todolist-users/mvnw .
COPY ./todolist-users/pom.xml .

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
#RUN ./mvnw dependency:go-offline

COPY ./todolist-users/src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-alpine

WORKDIR /app
RUN mkdir ./logs
COPY --from=builder /app/todolist-users/target/todolist-users-0.0.1-SNAPSHOT.jar .
EXPOSE 8081

CMD ["java", "-jar", "todolist-users-0.0.1-SNAPSHOT.jar"]