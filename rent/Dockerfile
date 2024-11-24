FROM amazoncorretto:21-alpine3.20

COPY ./target/*.jar /code/app.jar

WORKDIR code

CMD ["java", "-jar", "app.jar"]