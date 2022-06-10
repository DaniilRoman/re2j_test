#!/bin/bash
mvn clean install -DskipTests=true
java -jar ./target/benchmarks.jar