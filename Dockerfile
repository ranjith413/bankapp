FROM eclipse-temurin:17-jre-alpine
WORKDIR /opt/app
COPY /target/bank-app.jar bank-app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "bank-app.jar"]