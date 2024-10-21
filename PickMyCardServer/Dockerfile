# 1. Java JDK 21을 포함한 베이스 이미지 사용
FROM openjdk:21

# 2. 컨테이너 외부에서 8761 포트를 사용할 수 있도록 노출
EXPOSE 8761

# 3. 작업 디렉토리 설정
WORKDIR /app

# 4. 소스 코드 복사
COPY . .

# 6. 환경 변수 설정 (Eureka 서버 주소)
ENV EUREKA_CLIENT_SERVICEURL_DEFAULTZONE=http://pickmycardserver:8761/eureka

# 7. 빌드된 JAR 파일을 실행
# 빌드 후 생성된 JAR 파일을 실행하는 방식으로 수정
ENTRYPOINT ["java", "-jar", "./build/libs/PickMyCardServer-0.0.1-SNAPSHOT.jar"]
