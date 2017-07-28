package com.moviereel.data

import com.moviereel.data.api.ApiHelper
import com.moviereel.data.db.DbHelper
import com.moviereel.data.files.FileHelper
import com.moviereel.data.prefs.PreferencesHelper

/**
 * @author lusinabrian on 28/03/17
 * * Interface that will extend all other data layer components. This will delegate tasks to the
 * * corresponding layer based on the data received.
 */

interface DataManager : DbHelper, PreferencesHelper, ApiHelper, FileHelper
