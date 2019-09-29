#!/bin/bash

# generate flatbuffers classes
#~/git_tree/flatbuffers/flatc -o benchmark/src/androidTest/assets --unknown-json --binary --flexbuffers benchmark/src/androidTest/assets/asteroids.json
~/git_tree/flatbuffers/flatc -o benchmark/src/androidTest/assets --unknown-json --binary schemas/asteroids.fbs benchmark/src/androidTest/assets/asteroids.json
~/git_tree/flatbuffers/flatc -o serializers/src/main/java/ --java schemas/asteroids.fbs

# generate protobuf classes
protoc --java_out=serializers/src/main/java/  schemas/asteroids.proto
