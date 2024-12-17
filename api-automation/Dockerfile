FROM openjdk:17
COPY . /usr/src/qa-automation
WORKDIR /usr/src/qa-automation
RUN mvn clean install
ENTRYPOINT ["mvn", "test"]