FROM maven:3.5.2-jdk-8-alpine

RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

COPY settings.xml /usr/share/maven/ref/
COPY . /usr/src/app

RUN /usr/local/bin/mvn-entrypoint.sh mvn clean install \
     && cp -R ./target/*.jar ../app.jar \
     && rm -R /usr/src/app/ \
     && rm -R /usr/share/maven/ref/repository/

EXPOSE 8088
CMD ["java", "-jar", "/usr/src/app.jar"]