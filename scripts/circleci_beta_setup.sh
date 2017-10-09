#!/usr/bin/env bash

export FABRIC_PROPERTIES_FILE=$HOME"/app/fabric.properties"
export GRADLE_PROPERTIES=$HOME"/gradle.properties"
echo "RELEASE_TRACK=\"beta\"" >> ${GRADLE_PROPERTIES}

if [ ! -f "${FABRIC_PROPERTIES_FILE}" ]; then
    echo "${FABRIC_PROPERTIES_FILE} not found, creating"
    touch ${FABRIC_PROPERTIES_FILE}
    echo "apiSecret=$apiSecret" >> ${FABRIC_PROPERTIES_FILE}
fi

if [ "${CIRCLE_BRANCH}" == "staging" ] ;then
    ./gradlew assembleRelease crashlyticsUploadDistributionRelease
elif [ "${CIRCLE_BRANCH}" == "develop" ];then
    ./gradlew assembleDebug crashlyticsUploadDistributionDebug
fi