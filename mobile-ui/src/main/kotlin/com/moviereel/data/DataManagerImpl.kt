package com.moviereel.data

import com.moviereel.data.repositories.RepositoryHelper
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author lusinabrian on 28/03/17
 * * [Singleton] indicates that there will only be one object of this in the entire application
 * * thus ensuring that the app does not have several objects that will interact with the Model layer
 * * of the application
 * * The constructor is annoted with [Inject] to instruct dagger to accumulate all the param
 * * dependencies when class is being constructed
 * Constructor for the DataMangerImpl. This will create a new object of this class with the
 * following params
 * @param mFileHelper interface when interacting with the File helper class for interacting
 * with files
 * @param mPreferenceHelper preference interface when interacting with the preference layer
 * of the application when storing data persistently in [android.content.SharedPreferences]
 * */

@Singleton
class DataManagerImpl
@Inject
constructor(val mRepositoryHelper: RepositoryHelper) : DataManager
