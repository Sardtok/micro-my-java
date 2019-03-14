FROM gradle:jdk8 as builder
COPY --chown=gradle:gradle . /home/gradle/mn-todo
WORKDIR /home/gradle/mn-todo
RUN ./gradlew build

FROM openjdk:8u171-alpine3.7
EXPOSE 8080
COPY --from=builder /home/gradle/mn-todo/build/libs/*-all.jar mn-todo.jar
CMD java ${JAVA_OPTS} -jar mn-todo.jar