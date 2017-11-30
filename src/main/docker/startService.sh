#!/bin/sh

touch /app.jar

if [[ -z "${java_runtime_arguments}" ]]; then
 java $java_runtime_arguments -jar /app.jar
else
 java -Xms480m -Xmx480m -jar /app.jar
 fi