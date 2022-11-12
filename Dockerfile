FROM openjdk:11

ADD app/app-java/target/data-sentry-1.0-SNAPSHOT-jar-with-dependencies.jar /usr/src/datasentry/datasentry.jar

WORKDIR /usr/src/datasentry

CMD ["java", "-jar", "datasentry.jar"]