#!/bin/sh

./gradlew check --daemon

codeQualityResult=$?

if [ $codeQualityResult -ne 0 ]
then
    echo "Code violations were found. Please fix them to proceed with commit"
    exit 1
fi

./gradlew test --daemon

testResult=$?

if [ $testResult -ne 0 ]
then
    echo "Tests failed. Please fix them to proceed with commit"
    exit 1
fi

exit 0