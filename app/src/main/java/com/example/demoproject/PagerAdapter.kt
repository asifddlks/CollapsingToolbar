package com.example.demoproject

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class PagerAdapter(fm:FragmentManager, private val numOfTabs:Int):FragmentStatePagerAdapter(fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int {
        return numOfTabs
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                TabOne()
            }
            1 -> {
                TabTwo()
            }
            2 -> {
                TabThree()
            }
            else -> {
                TabOne()
            }
        }
    }
}