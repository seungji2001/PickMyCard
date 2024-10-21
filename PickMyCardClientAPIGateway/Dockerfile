FROM openjdk:21

WORKDIR /app

# Gradle 파일들 복사
COPY . .

EXPOSE 9001

ENV SERVER_PORT=9001
ENV EUREKA_CLIENT_SERVICEURL_DEFAULTZONE=http://pickmycardserver:8761/eureka

ENTRYPOINT ["java", "-jar", "./build/libs/PickMyCardClientAPIGateway-0.0.1-SNAPSHOT.jar"]
