package com.moviereel.ui.intro

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat

import com.github.paolorotolo.appintro.AppIntro2
import com.github.paolorotolo.appintro.AppIntroFragment
import com.moviereel.R
import com.moviereel.ui.main.MainActivity
import com.moviereel.utils.ClassPreamble

@ClassPreamble(author = "Brian Lusina", date = "05/09/16", currentRevision = 2, briefDescription = "For application introduction for first time users", lastModified = "18/3/17", lastModifiedBy = "Brian Lusina", reviewers = arrayOf("Brian Lusina"))
class AppIntroduction : AppIntro2() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*1st Fragment*/
        addSlide(AppIntroFragment.newInstance(
                getString(R.string.app_name),
                getString(R.string.movie_app_intro_1_desc),
                R.drawable.play_movies_icon,
                ContextCompat.getColor(this, R.color.wheat))
        )

        /*2nd Fragment*/
        addSlide(AppIntroFragment.newInstance(
                getString(R.string.movie_app_intro_2_title),
                getString(R.string.movie_app_intro_2_desc),
                R.drawable.play_movies_icon,
                ContextCompat.getColor(this, R.color.wheat))
        )

        /*3rd Fragment*/
        addSlide(AppIntroFragment.newInstance(
                getString(R.string.movie_app_intro_3_title),
                getString(R.string.movie_app_intro_3_desc),
                R.drawable.television_icon,
                ContextCompat.getColor(this, R.color.indigo_500))
        )

        /*4th Fragment*/
        addSlide(AppIntroFragment.newInstance(
                getString(R.string.app_name),
                getString(R.string.movie_app_intro_4_desc),
                R.mipmap.ic_launcher,
                ContextCompat.getColor(this, R.color.md_indigo_400))
        )

        isProgressButtonEnabled = true

        /*animation*/
        setDepthAnimation()
    }

    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)
        openMain()
        finish()
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        openMain()
        finish()
    }

    override fun onSlideChanged(oldFragment: Fragment?, newFragment: Fragment?) {
        super.onSlideChanged(oldFragment, newFragment)
    }

    /**open main activity */
    fun openMain() {
        val openMain = Intent(this@AppIntroduction, MainActivity::class.java)
        startActivity(openMain)
    }
}