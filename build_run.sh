#!/bin/bash

set -e 

./gradlew clean build

mkdir build/distributions/tmp
cd build/distributions/tmp

cp ../homer.zip . 
unzip homer.zip

cd homer 

./bin/homer links.txt homer.properties accordion

cd ../../../..
