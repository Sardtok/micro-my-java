FROM gradle:5.5.1-jdk8
COPY --chown=gradle:gradle . /home/gradle/
WORKDIR /home/gradle/
RUN mkdir gradle_home
ENV GRADLE_USER_HOME /home/gradle/gradle_home
RUN gradle build --build-cache --no-daemon
