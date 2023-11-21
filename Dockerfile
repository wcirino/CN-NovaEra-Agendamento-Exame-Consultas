FROM openjdk:8-jre-alpine
#RUN mkdir /app
WORKDIR /app
COPY target/cn-agendamento-exame-consulta-0.0.1-SNAPSHOT.jar app.jar
#EXPOSE 8056
CMD ["java", "-jar", "app.jar"]
