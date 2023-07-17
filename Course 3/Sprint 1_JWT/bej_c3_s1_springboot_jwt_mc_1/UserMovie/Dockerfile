# need openjdk
FROM openjdk

#work directory
WORKDIR usr/lib

# jar
ADD ./target/UserMovie-0.0.1-SNAPSHOT.jar /usr/lib/UserMovie-0.0.1-SNAPSHOT.jar

# add starting jars when containerstart
ENTRYPOINT ["java","-jar","UserMovie-0.0.1-SNAPSHOT.jar"]