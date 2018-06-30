#!/bin/bash

cd configserver 
mvn spring-boot:run

cd ..
cd discoveryserver 
mvn spring-boot:run

cd ..
cd gateway 
mvn spring-boot:run

cd ..
cd ui 
mvn spring-boot:run