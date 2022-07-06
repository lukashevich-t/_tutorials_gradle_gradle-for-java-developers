#!/bin/bash

echo no | gradle init --dsl groovy --package by.efreet.gradle --test-framework junit --type java-application --project-name 03-firstWebApp
gradle wrapper --gradle-version 7.4.2 --distribution-type bin