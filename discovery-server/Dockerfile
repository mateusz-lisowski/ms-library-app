FROM amazoncorretto:21-alpine3.20

RUN apk --no-cache add curl

COPY ./target/*.jar /code/app.jar

WORKDIR code

CMD ["java", "-jar", "app.jar"]