#!/bin/sh

if [ $# -eq 0 ]; then
 goals="clean install"
else
 goals=$@
fi 

mvn -f fr.unice.i3s.sigma.releng/pom.xml $goals
