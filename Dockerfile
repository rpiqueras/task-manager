FROM openjdk:8-jdk-alpine
ARG JAR_FILE=usermanager/target/*.jar
COPY ${JAR_FILE} usermanager.jar
ENTRYPOINT ["java","-jar","usermanager.jar"]