FROM openjdk:8-jdk-alpine

MAINTAINER Intelligent Empowerment Ecuador <intelligent-empowerment-ecuador@thoughtworks.com>

WORKDIR /nlp-sandbox

COPY gradle gradle
COPY build.gradle build.gradle
COPY settings.gradle settings.gradle
COPY gradlew gradlew

RUN ./gradlew build