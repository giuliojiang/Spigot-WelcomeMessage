#!/bin/bash

# cd to this directory
cd "$(dirname "$0")"
ROOTDIR="$(pwd)"

rm -rf build

# Create out/production/WelcomeMessage/WelcomeMessage.jar
cd out/production/WelcomeMessage
zip -r WelcomeMessage.jar .

cd $ROOTDIR
pwd
mkdir build
mv out/production/WelcomeMessage/WelcomeMessage.jar build/WelcomeMessage.jar