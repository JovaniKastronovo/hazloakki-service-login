#!/usr/bin/env bash

gradle bootRepackage && cp build/libs/app.jar src/main/docker/app/app.jar && cd src/main/docker &&
sudo docker-compose up --build

