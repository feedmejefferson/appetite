FROM openjdk:8-jre
RUN mkdir /usr/src/hunger
COPY target/hunger-0.3.jar /usr/src/hunger/
COPY config.yml /usr/src/hunger/
WORKDIR /usr/src/hunger
VOLUME /usr/src/hunger/logs
EXPOSE 9000 9001
CMD ["java", "-jar", "hunger-0.3.jar", "server", "config.yml"]
