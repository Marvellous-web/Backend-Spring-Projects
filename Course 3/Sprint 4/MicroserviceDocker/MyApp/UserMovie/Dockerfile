FROM openjdk

WORKDIR usr/lib

ADD ./target/UserMovie-0.0.1-SNAPSHOT.jar /usr/lib/UserMovie-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","UserMovie-0.0.1-SNAPSHOT.jar"]