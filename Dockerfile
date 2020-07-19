FROM maven:3.5.3-jdk-8-slim as jar
WORKDIR /jcat
COPY pom.xml ./
COPY src src
RUN mvn clean package

FROM openjdk:8-alpine
WORKDIR /jcat
COPY --from=jar /jcat/target/comments-*-jar-with-dependencies.jar jcat.jar
COPY jcat.sh .
VOLUME /jcat/allure-results
LABEL maintainer="Dmytro Serdiuk <dmytro.serdiuk@gmail.com>" \
      sources="https://github.com/extsoft/jcat" \
      versions="https://store.docker.com/community/images/extsoft/jcat/tags"
ENV SELENIUM_URL="http://selenium-hub:4444/wd/hub" \
    BROWSER="chrome"
CMD ["./jcat.sh"]
