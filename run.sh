#!/bin/bash

sbt clean
sbt stage

cd target/universal/stage/
./bin/iloveyou