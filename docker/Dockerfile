FROM circleci/jdk8:0.1.1
LABEL maintainer=cg

COPY target/docker-test.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]
