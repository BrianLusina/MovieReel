package com.moviereel.utils

import kotlin.annotation.MustBeDocumented

/**
 * author lusinabrian
 */

@MustBeDocumented
annotation class ClassPreamble(val author: String, val date: String, val currentRevision: Int = 1, val lastModified: String = "N/A", val lastModifiedBy: String = "N/A", val briefDescription: String, val reviewers: Array<String>)
