#!/bin/sh

ARGS=""
if [ $# -eq 1 ]; then
  ARGS="install"
else
  ARGS=$@
fi
mvn -f releng/fr.unice.i3s.sigma.releng/pom.xml $ARGS
