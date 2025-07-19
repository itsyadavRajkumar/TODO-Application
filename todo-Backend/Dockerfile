FROM openjdk:17
WORKDIR /app
COPY target/Todo-Application.jar /app/Todo-Application.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/Todo-Application.jar"]


#docker build -t todo-app .
#docker run -p 8080:8080 todo-app