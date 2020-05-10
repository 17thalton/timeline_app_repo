package com.designtesting.timelineappdev1


import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import java.security.AccessController.getContext


@Suppress("DEPRECATION")
class PagerAdapter (fm: FragmentManager, c: Context) : FragmentPagerAdapter(fm) {

    //context gained fromm TimetableActivity (needed for getting strings in getPageTitle)
    val context = c

    //return total amount of tabs
    override fun getCount(): Int {
        return 5
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> MondayFragment()
            1 -> TuesdayFragment()
            2 -> WednesdayFragment()
            3 -> ThursdayFragment()
            else -> FridayFragment()
        }
    }


    //names for each tab
    override fun getPageTitle(position: Int): CharSequence? {

        return when (position) {

            0 -> context.getString(R.string.short_monday)
            1 -> context.getString(R.string.short_tuesday)
            2 -> context.getString(R.string.short_wednesday)
            3 -> context.getString(R.string.short_thursday)
            else -> context.getString(R.string.short_friday)
        }
    }
}



