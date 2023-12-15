#image
FROM openjdk:11-jdk-slim-stretch

#Creating volume
VOLUME /tmp

USER root
COPY openweathermap.crt $JAVA_HOME/lib/security
RUN \
    cd $JAVA_HOME/lib/security/ \
    && keytool -keystore cacerts -storepass changeit -noprompt -trustcacerts -importcert -alias weathercert -file openweathermap.crt

WORKDIR /opt/app
#Copy the target folder to new one
COPY target/weather-0.0.1-SNAPSHOT.jar app.jar

#Create entrypoint for image
ENTRYPOINT ["java", "-jar", "app.jar"]