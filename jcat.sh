#!/bin/sh
set -e

COMMAND=$(echo "java -Dselenium-url=${SELENIUM_URL} -Dbrowser=${BROWSER} -jar jcat.jar")
echo "Execute: ${COMMAND}"
eval "${COMMAND}"
