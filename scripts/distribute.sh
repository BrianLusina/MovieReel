#!/usr/bin/env bash


createBuildDist(){
	if [[ ${2} = "release" ]] ;then
		# create release
		../gradlew ${1}:assembleRelease crashlyticsUploadDistributionRelease
	else
		../gradlew ${1}:assembleDebug crashlyticsUploadDistributionRelease
	fi
}

# arguments to pass in, {1} is the name of the module, {2} is the buildType, release or debug
createBuildDist ${1} ${2}
