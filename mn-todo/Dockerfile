FROM gradle:5.5-jdk8 as builder
COPY --chown=gradle:gradle . /home/gradle/mn-todo
WORKDIR /home/gradle/mn-todo
RUN gradle build

FROM oracle/graalvm-ce:19.2.0 as graalvm
COPY --from=builder /home/gradle/mn-todo/ /home/app/mn-todo/
WORKDIR /home/app/mn-todo
RUN gu install native-image
RUN native-image --no-server -cp build/libs/mn-todo-*-all.jar

FROM frolvlad/alpine-glibc
EXPOSE 8080
COPY --from=graalvm /home/app/mn-todo .
ENTRYPOINT ["./mn-todo"]
