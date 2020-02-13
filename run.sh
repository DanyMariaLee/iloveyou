#!/bin/bash

FILE=./target/universal/stage/bin/iloveyou

if [[ -f "$FILE" ]]; then
    ./target/universal/stage/bin/iloveyou
else
sbt clean
sbt stage

cd target/universal/stage/
./bin/iloveyou

fi