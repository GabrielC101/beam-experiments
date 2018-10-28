#!/bin/bash

MAIN_CLASS=org.gabrielcurio.tutorials.beam.wordcount.WordCountApp
INPUT_FILE=gs://apache-beam-samples/shakespeare/kinglear.txt
OUTPUT_DIR=./ignore
OUTPUT_PREFIX=/counts
OUTPUT_PATH=$OUTPUT_DIR$OUTPUT_PREFIX
RUNNER=direct-runner

rm $OUTPUT_DIR/*

mvn compile exec:java \
-Dexec.mainClass=$MAIN_CLASS \
"-Dexec.args=--inputFile=$INPUT_FILE \
--output=$OUTPUT_PATH" \
-P$RUNNER