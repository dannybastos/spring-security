FROM dannybastos/openjdk11

MAINTAINER Danny Bastos <danny.bastos.br@gmail.com>

WORKDIR /app

COPY . /app

RUN ./gradlew clean build

RUN mv /app/build/libs/spring-security*.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT java -jar /app/app.jar
