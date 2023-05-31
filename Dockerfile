FROM openjdk:17-ea-jdk-slim

VOLUME /tmp

EXPOSE 8081

RUN apt update && apt install -y curl iputils-ping telnet unzip && apt clean all

ARG JAR_FILE=/target/restful-0.0.1-SNAPSHOT.jar

RUN mkdir -p /app/gmt
WORKDIR /app/gmt
ADD ${JAR_FILE} app.jar
RUN chmod 777 /app/gmt/app.jar

ENTRYPOINT ["java", "-Xmx2048M", "-Xms1024M", "-jar", "app.jar"]
