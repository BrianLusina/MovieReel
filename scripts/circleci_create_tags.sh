#!/usr/bin/env bash

export APK_DIR=$HOME/"/moja-dir/mojaapp/build/outputs/apks/"
export APK_DIR_RELEASE=${APK_DIR}"release/"
export VERSION_NAME_PREFIX="v"
export VERSION_NAME_RC_SUFFIX="rc${CIRCLE_BUILD_NUM}"

# Creates APK tags and releases to the repo
echo "Creating release for ${CIRCLE_PROJECT_REPONAME} ..."

# checks if ghr has been installed
function checkGhrIsInstalled(){
    if ! [ -x "$(command -v ghr)" ]; then
        echo 'Error: ghr is not installed.' >&2
        echo "Installing ghr"
        go get -u github.com/tcnksm/ghr
    fi
    echo "ghr is installed, proceed to creating tags ..."
}

# create apk tags for the application
# this will be used to enable QA team to download the apks automatically after a successful build
# TODO: dynamically create version names for tags to use
function createApkReleases(){
    checkGhrIsInstalled

    if [ "${CIRCLE_BRANCH}" == "master" ];then
        echo "Creating release tags ..."
        ghr -u ${CIRCLE_USERNAME} -r ${CIRCLE_PROJECT_REPONAME} "${VERSION_NAME_PREFIX}1.0.0" ${APK_DIR_RELEASE}
    elif [ "${CIRCLE_BRANCH}" == "staging" ];then
        echo "Creating pre-release tags ..."
        ghr -u ${CIRCLE_USERNAME} -r ${CIRCLE_PROJECT_REPONAME} --prerelease "${VERSION_NAME_PREFIX}1.0.0-${VERSION_NAME_RC_SUFFIX}" ${APK_DIR_RELEASE}
    fi
}

# creating apk releases
createApkReleases