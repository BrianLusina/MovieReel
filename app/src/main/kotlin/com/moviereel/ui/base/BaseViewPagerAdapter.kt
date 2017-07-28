package com.moviereel.ui.base

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

/**
 * @author lusinabrian on 10/06/17.
 * @Notes Base view pager adapter that will be used in application to subclass all other
 * view pagers
 */
abstract class BaseViewPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager){
    private val fragmentList = mutableListOf(Fragment())
    private val fragmentTitleList = mutableListOf(String())
    private lateinit var itemObject : Any

    /**
     * Secondary constructor
     * */
    constructor(fragmentManager: FragmentManager, itemObject: Any): this(fragmentManager){
        this.itemObject = itemObject
    }

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return fragmentTitleList[position]
    }


    /**Adds fragment to the viewpager
     * @param fragment The fragment to add to the viewpager
     * @param fragTitle The title of the fragment
     */
    fun addFragment(fragment: Fragment, fragTitle: String) {
        fragmentList.add(fragment)
        fragmentTitleList.add(fragTitle)
    }
}