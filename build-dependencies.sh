#!/bin/sh

if [ $# -eq 0 ]; then
 goals="clean install"
else
 goals=$@
fi 

mvn -f external/fr.unice.i3s.sigma.external.releng/pom.xml $goals
