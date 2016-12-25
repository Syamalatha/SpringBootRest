FROM anapsix/alpine-java
COPY testprj-1.0-SNAPSHOT.jar /home/testprj-1.0-SNAPSHOT.jar
CMD ["java","-jar","/home/testprj-1.0-SNAPSHOT.jar”]