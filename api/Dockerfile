FROM maven:3.6.0-jdk-8 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean verify

FROM openjdk:8-jdk-alpine
LABEL maintainer="Ed Briggler - <edward.briggler@gmail.com>"

RUN adduser -S springweb
USER springweb
VOLUME /tmp
COPY --from=build /usr/src/app/target/password-encrypt.jar app.jar

ENTRYPOINT [ \
    "java", \
    "-Djava.security.egd=file:/dev/./urandom", \
    "-jar", \
    "/app.jar" \
    ]
