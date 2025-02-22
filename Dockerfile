FROM maven:3.9.8-eclipse-temurin-21 as build
WORKDIR /app
COPY . .
RUN mvn clean package -T 1C -DskipTests

FROM eclipse-temurin:21-jdk-jammy
RUN useradd -ms /bin/bash smarthome
WORKDIR /app

COPY --from=build --chown=smarthome /app/target/*.jar /app/app.jar

USER smarthome

EXPOSE 8080

# ZGC config (cho latency thấp)
#ENV JAVA_OPTS="-XX:+UseZGC -Xms2g -Xmx2g -XX:MaxGCPauseMillis=200 -XX:+ZUncommit -Xlog:gc*,safepoint:gc.log"

# Hoặc Shenandoah config (cho throughput cao)
 ENV JAVA_OPTS="-XX:+UseShenandoahGC -Xms4g -Xmx4g -XX:ShenandoahGCMode=iu -Xlog:gc*,ergo*=trace"

ENTRYPOINT ["java", "-jar", "/app/app.jar"]