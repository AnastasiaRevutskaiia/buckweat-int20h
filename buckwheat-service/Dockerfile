FROM openjdk:11-jre-slim
ARG SERP_WOW_TOKEN
COPY target/buckwheat-service-1.0-SNAPSHOT.jar /buckwheat-service.jar
EXPOSE 9999
ENTRYPOINT ["java", "-DSERP_WOW_TOKEN=${SERP_WOW_TOKEN}", "-jar", "/buckwheat-service.jar"]
