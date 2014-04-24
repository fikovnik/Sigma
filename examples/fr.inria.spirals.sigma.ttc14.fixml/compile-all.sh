#!/bin/bash

pushd . > /dev/null

for msg in output/*; do
  pushd . > /dev/null
  cd $msg

	if [[ -d java ]]; then
    echo "$msg: Compiling Java"
    cd java
	  javac *.java
    cd ..
  fi

  if [[ -d cs ]]; then
    echo "$msg: Compiling C#"
    cd cs
	  gmcs -target:library *.cs
	  cd ..
  fi

  if [[ -d cpp ]]; then
    echo "$msg: Compiling C++"
    cd cpp
   	g++ -c *.cpp
	  g++ -shared -o lib$msg.so *.o
	  cd ..
	fi
  
  popd > /dev/null

done

popd  > /dev/null