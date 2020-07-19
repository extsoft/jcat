#!/bin/sh
set -e

highlight() {
  echo " >>> ${*}"
}

wait_selenium() {
  highlight "Waiting for Selenium daemon is ready to accept connections..."
  counter=0
  while true; do
    counter=$((counter+1))
    ( wget --quiet --output-document - ${SELENIUM_URL}/status | grep '"ready":true') ||
      {
        if test ${counter} -gt 30 ; then
          echo "Operation timed out!" >&2
          echo "Selenium daemon on is not ready after 30 seconds." >&2
          echo "Selenium daemon URL: ${SELENIUM_URL}" >&2
          exit 1
        fi
        echo 'Selenium daemon is not ready... Waiting one more second...'
        sleep 1s
        continue
      }
    highlight 'Selenium daemon is ready!'
    break
  done
}

run_jcat() {
  COMMAND="java -Dselenium-url=${SELENIUM_URL} -Dbrowser=${BROWSER} -jar jcat.jar"
  highlight "Run tests: ${COMMAND}"
  exec ${COMMAND}
}

main() {
  wait_selenium
  run_jcat
}

main
