FROM test/com.att.ajsc.public/anapsix/alpine-java:8_jdk
VOLUME /tmp
ADD HazleCast1.jar app.jar
VOLUME /etc
ADD /etc/ /etc/
ADD startService.sh /startService.sh
RUN chmod 700 /startService.sh
ENTRYPOINT ./startService.sh 
