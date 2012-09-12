#!/bin/sh

if [ ! -d fr.unice.i3s.sigma.releng.p2/target/reposiotry ]; then
  ./build-dependencies.sh
fi

if [ $# -eq 0 ]; then
 goals="clean install"
else
 goals=$@
fi 

mvn -f fr.unice.i3s.sigma.releng/pom.xml $goals
