FROM sardtok/mmj-builder:latest as builder
COPY --chown=gradle:gradle . /home/gradle/
RUN gradle build --no-daemon

FROM adoptopenjdk/openjdk8-openj9:jdk8u242-b08_openj9-0.18.1-alpine-slim
COPY --from=builder /home/gradle/build/libs/mn-todo-*-all.jar mn-todo.jar
EXPOSE 8080
CMD java -Dcom.sun.management.jmxremote -noverify ${JAVA_OPTS} -jar mn-todo.jar
