FROM openjdk:17-jdk-slim

WORKDIR /app
RUN mkdir -p /app/src /app/out

COPY ./Hello.java /app/src

RUN javac -d /app/out /app/src/Hello.java

CMD ["java", "-cp", "/app/out", "Hello"]