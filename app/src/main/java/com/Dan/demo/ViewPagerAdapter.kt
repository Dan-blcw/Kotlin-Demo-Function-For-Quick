package com.Dan.demo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStateManagerControl
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(
    fragmentManager: FragmentManager,
    lifeCycle: Lifecycle
    ): FragmentStateAdapter(fragmentManager,lifeCycle){
    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->{BlankFragment1()}
            1->{BlankFragment2()}
            else -> {BlankFragment3()}
        }
    }

}