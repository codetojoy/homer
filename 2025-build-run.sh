#!/bin/bash

set -e 

stat links.txt > /dev/null 2>&1

ORIG_DIR=$PWD

./gradlew clean build

TMP_DIR=build/distributions/tmp
HOMER_DIR=build/distributions/tmp/homer

mkdir $TMP_DIR
cd $TMP_DIR

cp ../homer.zip . 
unzip homer.zip

cd homer 

cp $ORIG_DIR/links.txt .
./bin/homer links.txt homer.properties accordion

cd $ORIG_DIR

open ./$HOMER_DIR/home.html
