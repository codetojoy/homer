#!/bin/bash

set -e

echo "starting..."
cd staging
java -jar homer.jar links.txt resources/homer.properties
cd - 
