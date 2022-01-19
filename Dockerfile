
FROM  maven:3.6.3-openjdk-17 AS maven
COPY pom.xml /tmp/
COPY src /tmp/src/

WORKDIR /tmp/
RUN mvn package -Dmaven.test.skip=true

FROM openjdk:17-oraclelinux7

EXPOSE 2003

COPY --from=maven /tmp/target/discor_bot-0.0.1-SNAPSHOT.jar /data/jarJarBeans.jar
CMD java -jar /data/jarJarBeans.jar --server.port=8080 --spring.profiles.active=prod