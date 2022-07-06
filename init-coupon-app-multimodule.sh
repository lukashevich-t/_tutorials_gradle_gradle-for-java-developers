#!/bin/bash

targetPath=04-couponAppMulti-temp
targetPath=`realpath ${targetPath}`
rm -rf "${targetPath}"
mkdir "${targetPath}"
cd "${targetPath}"
echo no | gradle init --dsl groovy --package by.efreet.gradle --test-framework junit --type java-application --project-name couponapp
gradle wrapper --gradle-version 7.4.2 --distribution-type bin

mkdir data integration services web

rm -rf app

for name in data integration services
do
    cd "$targetPath/$name"
    echo no | gradle init --dsl groovy --type basic --project-name $name
done


