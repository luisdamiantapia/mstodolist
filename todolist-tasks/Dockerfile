FROM openjdk:17-jdk-alpine as builder

WORKDIR /app/todolist-tasks

COPY ./pom.xml /app
COPY ./todolist-tasks/.mvn ./.mvn
COPY ./todolist-tasks/mvnw .
COPY ./todolist-tasks/pom.xml .

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
#RUN ./mvnw dependency:go-offline
COPY ./todolist-tasks/src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-alpine

WORKDIR /app
RUN mkdir ./logs
COPY --from=builder /app/todolist-tasks/target/todolist-tasks-0.0.1-SNAPSHOT.jar .
EXPOSE 8082

CMD ["java", "-jar", "todolist-tasks-0.0.1-SNAPSHOT.jar"]