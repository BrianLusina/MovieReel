#!/usr/bin/env bash

# references
# 1. http://deathstartup.com/?p=81
# 2. https://gist.github.com/KioKrofovitch/716e6a681acb33859d16
# 3. https://stackoverflow.com/questions/35440907/can-circle-ci-reference-gradle-properties-credentials

export GRADLE_PROPERTIES=$HOME"/gradle.properties"
export KEYSTORE_PROPERTIES=$HOME"/keystores/keystore.properties"
export PUBLISH_KEY_FILE=$HOME"/keystores/moviereel_publish_key.json"
export STORE_FILE_LOCATION=$HOME"/moviereel.jks"
export FABRIC_PROPERTIES_FILE=$HOME"/app/fabric.properties"
export GOOGLE_SERVICES_DEBUG_LOCATION=$HOME"/app/src/debug/google-services.json"
export GOOGLE_SERVICES_RELEASE_LOCATION=$HOME"/app/src/main/google-services.json"

function copyEnvVarsToProperties {

    echo "Gradle Properties should exist at $GRADLE_PROPERTIES"
    echo "Keystore Properties should exist at $KEYSTORE_PROPERTIES"

    if [ ! -f "$KEYSTORE_PROPERTIES" ]
    then
        echo "${KEYSTORE_PROPERTIES} does not exist...Creating file"

        touch ${KEYSTORE_PROPERTIES}

        echo "keyAlias=$KEY_ALIAS" >> ${KEYSTORE_PROPERTIES}
        echo "keyPassword=$KEY_PASSWORD" >> ${KEYSTORE_PROPERTIES}
        echo "storeFile=$STORE_FILE" >> ${KEYSTORE_PROPERTIES}
        echo "storePassword=$STORE_PASSWORD" >> ${KEYSTORE_PROPERTIES}
    fi

    if [ ! -f "$GRADLE_PROPERTIES" ]
    then
        echo "${GRADLE_PROPERTIES} does not exist...Creating Properties file"

        touch ${GRADLE_PROPERTIES}
        echo "MovieDbKey=$MovieDbKey" >> ${GRADLE_PROPERTIES}
        echo "IMAGE_BASE_URL=$IMAGE_BASE_URL" >> ${GRADLE_PROPERTIES}
        echo "IMAGE_SECURE_BASE_URL=$IMAGE_SECURE_BASE_URL" >> ${GRADLE_PROPERTIES}
        echo "MOVIE_REEL_SERVICE_ACCOUNT_EMAIL=$MOVIE_REEL_SERVICE_ACCOUNT_EMAIL" >> ${GRADLE_PROPERTIES}
        echo "FABRIC_KEY=$FABRIC_KEY" >> ${GRADLE_PROPERTIES}
    fi

    if [ ! -f "$PUBLISH_KEY_FILE" ]
    then
        echo "${PUBLISH_KEY_FILE} does not exist...creating properties file"

        touch ${PUBLISH_KEY_FILE}

        echo "$MOVIE_REEL_PUBLISH_KEY" >> ${PUBLISH_KEY_FILE}
    fi

    echo "Checking for fabric.properties file"
    if [! -f "${FABRIC_PROPERTIES_FILE}"]; then
	    echo "${FABRIC_PROPERTIES_FILE} not found, creating"
	    touch ${FABRIC_PROPERTIES_FILE}

	    echo "apiSecret=$apiSecret" >> ${FABRIC_PROPERTIES_FILE}
    fi
}

# download key store file from remote location
# keystore URI will be the location uri for the *.jks file for signing application
function downloadKeyStoreFile {
    # use curl to download a keystore from $KEYSTORE_URI, if set,
    # to the path/filename set in $KEYSTORE.
    echo "Looking for $STORE_FILE_LOCATION ..."

    if [ ! -f ${STORE_FILE_LOCATION} ] ; then
        echo "Keystore file is missing, performing download"
        # we're using curl instead of wget because it will not
        # expose the sensitive uri in the build logs:
        curl -L -o ${STORE_FILE} ${KEY_STORE_URI}
    else
            echo "Keystore uri not set.  .APK artifact will not be signed."
    fi
}

# this will download the google-services.json files from secure locations and store them for
# the CI to build successfully
function setupGoogleServicesJsonFiles {

    echo "Checking for ${GOOGLE_SERVICES_RELEASE_LOCATION}..."

    if [ ! -f ${GOOGLE_SERVICES_RELEASE_LOCATION} ]; then
        echo "google-services.json for release not found, downloading...."

        touch ${GOOGLE_SERVICES_RELEASE_LOCATION}

        curl -L -o ${GOOGLE_SERVICES_RELEASE_LOCATION} ${GOOGLE_SERVICES_RELEASE_URI}
    else
        echo "google-services.json not downloaded for release."
    fi

    echo "Checking for ${GOOGLE_SERVICES_DEBUG_LOCATION}..."

    if [ ! -f ${GOOGLE_SERVICES_DEBUG_LOCATION} ]; then
        echo "google-services.json for debug not found, downloading...."

        mkdir $HOME"/app/src/debug"
        touch ${GOOGLE_SERVICES_DEBUG_LOCATION}
        curl -L -o ${GOOGLE_SERVICES_DEBUG_LOCATION} ${GOOGLE_SERVICES_DEBUG_URI}
    else
        echo "google-services.json not downloaded for debug"
    fi
}

# updates the version code based on the current branch
function updateVersionCodeAndTrack(){
    versionCode=$(git rev-list --first-parent --count origin/${CIRCLE_BRANCH})
    versionName=$(git describe --dirty)

#    if ["${versionName}" == "fatal: No names found, cannot describe anything."]; then
#        major=$(expr ${CIRCLE_BUILD_NUM} - ${CIRCLE_PREVIOUS_BUILD_NUM})
#        versionName=${major}.0.0
#    fi

    # todo: handling version names for automated updates
    if ["${versionName}" == "fatal: No names found, cannot describe anything."]; then
        versionName=1.0.0
    fi

    if [ "${CIRCLE_BRANCH}" == "develop" ]; then
    	echo "VERSION_NAME=${versionName}" >> ${GRADLE_PROPERTIES}
	    echo "VERSION_CODE=${versionCode}" >> ${GRADLE_PROPERTIES}
	    echo "RELEASE_TRACK=\"beta\"" >> ${GRADLE_PROPERTIES}

	elif [ "${CIRCLE_BRANCH}" == "master" ] ; then
    	echo "VERSION_NAME=${versionName}" >> ${GRADLE_PROPERTIES}
	    echo "VERSION_CODE=${versionCode}" >> ${GRADLE_PROPERTIES}
        echo "RELEASE_TRACK=\"production\"" >> ${GRADLE_PROPERTIES}
	fi
}

# execute functions
copyEnvVarsToProperties
downloadKeyStoreFile
updateVersionCodeAndTrack
setupGoogleServicesJsonFiles
