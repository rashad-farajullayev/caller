FROM java:8-jre-alpine
WORKDIR /code/
COPY target/demo-0.0.1-SNAPSHOT.jar application.properties ./
EXPOSE 8080
CMD java -Dloader.path=. -jar demo-0.0.1-SNAPSHOT.jar