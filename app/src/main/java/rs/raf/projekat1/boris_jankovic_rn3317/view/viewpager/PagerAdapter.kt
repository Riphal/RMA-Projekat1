package rs.raf.projekat1.boris_jankovic_rn3317.view.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import rs.raf.projekat1.boris_jankovic_rn3317.R
import rs.raf.projekat1.boris_jankovic_rn3317.view.fragments.InfoFragment
import rs.raf.projekat1.boris_jankovic_rn3317.view.fragments.InputPatientFragment
import rs.raf.projekat1.boris_jankovic_rn3317.view.fragments.ProfileFragment
import rs.raf.projekat1.boris_jankovic_rn3317.view.fragments.ListFragment

class PagerAdapter (fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        private const val ITEM_COUNT = 4
        const val INFO_FRAGMENT = 0
        const val INPUT_FRAGMENT = 1
        const val LIST_FRAGMENT = 2
        const val PROFILE_FRAGMENT = 3
    }

    override fun getItem (position: Int): Fragment {
        return when(position) {
            INFO_FRAGMENT -> InfoFragment()
            INPUT_FRAGMENT -> InputPatientFragment()
            LIST_FRAGMENT -> ListFragment()
            else -> ProfileFragment()
        }
    }

    override fun getCount (): Int {
        return ITEM_COUNT
    }

    override fun getPageTitle (position: Int): CharSequence? {
        return when (position) {
            INFO_FRAGMENT -> R.string.navigation_info
            INPUT_FRAGMENT -> R.string.navigation_input
            LIST_FRAGMENT -> R.string.navigation_list
            else -> R.string.navigation_profile
        }.toString()
    }
}